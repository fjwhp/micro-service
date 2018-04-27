package com.whp.config.redis;

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
/**
 * 
 * @描述：新的序列化方法，新加入一种序列化KryoRedisSerializer。速度很快----- Kryo
 *
 * @作者：wuhp
 * 
 * @时间：2018年3月16日 下午2:52:39
 */
public class KryoRedisSerializer<T> implements RedisSerializer<T> {
  Logger logger = LoggerFactory.getLogger(KryoRedisSerializer.class);

  public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

  private static final ThreadLocal<Kryo> kryos = ThreadLocal.withInitial(Kryo::new);

  private Class<T> clazz;

  public KryoRedisSerializer(Class<T> clazz) {
      super();
      this.clazz = clazz;
  }

  @Override
  public byte[] serialize(T t) throws SerializationException {
      if (t == null) {
          return EMPTY_BYTE_ARRAY;
      }

      Kryo kryo = kryos.get();
      kryo.setReferences(false);
      kryo.register(clazz);

      try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
           Output output = new Output(baos)) {
          kryo.writeClassAndObject(output, t);
          output.flush();
          return baos.toByteArray();
      } catch (Exception e) {
          logger.error(e.getMessage(), e);
      }

      return EMPTY_BYTE_ARRAY;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T deserialize(byte[] bytes) throws SerializationException {
      if (bytes == null || bytes.length <= 0) {
          return null;
      }

      Kryo kryo = kryos.get();
      kryo.setReferences(false);
      kryo.register(clazz);

      try (Input input = new Input(bytes)) {
          return (T) kryo.readClassAndObject(input);
      } catch (Exception e) {
          logger.error(e.getMessage(), e);
      }

      return null;
  }

}
