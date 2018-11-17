package com.itplayer.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author caijun.yang
 * @date 2018/10/12
 */
@Service
public class RedisClientImpl implements RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String get(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] keys = serializer.serialize(key);
                byte[] values = redisConnection.get(keys);
                if (values == null) {
                    return null;
                }
                String value = serializer.deserialize(values);
                return value;
            }
        });
    }

    @Override
    public Set<String> keyStartWith(final String key) {
        Set<byte[]> keyPttens = redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
            @Override
            public Set<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.keys(getRedisSerializer().serialize(key));
            }
        });
        Set<String> keys = new HashSet<String>();
        if (null != keyPttens && keyPttens.size() > 0) {
            for (byte[] keypatt : keyPttens) {
                String deserialize = getRedisSerializer().deserialize(keypatt);
                keys.add(deserialize);
            }
        }
        return keys;
    }

    @Override
    public Boolean set(final String key, final String value) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] keys = serializer.serialize(key);
                byte[] values = serializer.serialize(value);
                redisConnection.set(keys, values);
                return true;
            }
        });
    }

    @Override
    public Long delete(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> redisSerializer = getRedisSerializer();
                byte[] keys = redisSerializer.serialize(key);
                return redisConnection.del(keys);
            }
        });
    }

    @Override
    public Boolean exists(final String key) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.exists(keys);
            }
        });
    }

    @Override
    public Long incr(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.incr(keys);
            }
        });
    }

    @Override
    public Long decr(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.decr(keys);
            }
        });
    }

    @Override
    public Long incrby(final String key, final Long offset) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.incrBy(keys, offset);
            }
        });
    }

    @Override
    public Long decrby(final String key, final Long offset) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.decrBy(keys, offset);
            }
        });
    }

    @Override
    public Long lpush(final String key, final String value) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                byte[] values = getRedisSerializer().serialize(value);
                return redisConnection.lPush(keys, values);
            }
        });
    }

    @Override
    public Long rpush(final String key, final String value) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                byte[] values = getRedisSerializer().serialize(value);
                return redisConnection.rPush(keys, values);
            }
        });
    }

    @Override
    public String lpop(final String key) {
        byte[] bytes = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.lPop(keys);
            }
        });
        return getRedisSerializer().deserialize(bytes);
    }

    @Override
    public String rpop(final String key) {
        byte[] bytes = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.rPop(keys);
            }
        });
        return getRedisSerializer().deserialize(bytes);
    }

    @Override
    public Long llen(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.lLen(keys);
            }
        });
    }

    @Override
    public Long sadd(final String key, final String value) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.sAdd(keys, getRedisSerializer().serialize(value));
            }
        });
    }

    @Override
    public String sPop(final String key) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.sPop(keys);
            }
        });
        return getRedisSerializer().deserialize(result);
    }

    @Override
    public Long scard(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[] keys = getRedisSerializer().serialize(key);
                return redisConnection.sCard(keys);
            }
        });
    }

    @Override
    public Boolean hset(final String key, final String field, final String value) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.hSet(
                        getRedisSerializer().serialize(key),
                        getRedisSerializer().serialize(field),
                        getRedisSerializer().serialize(value)
                );
            }
        });
    }

    @Override
    public String hget(final String key, final String field) {
        byte[] bytes = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.hGet(getRedisSerializer().serialize(key),
                        getRedisSerializer().serialize(field));
            }
        });
        String deserialize = getRedisSerializer().deserialize(bytes);
        return deserialize;
    }

    @Override
    public Long hdel(final String key, final String field) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.hDel(getRedisSerializer().serialize(key), getRedisSerializer().serialize(field));
            }
        });
    }

    @Override
    public Boolean hexists(final String key, final String field) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.hExists(
                        getRedisSerializer().serialize(key),
                        getRedisSerializer().serialize(field)
                );
            }
        });
    }
    
	@Override
	public Boolean set(final String key, final String value, Long time) {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = getRedisSerializer();
                byte[] keys = serializer.serialize(key);
                byte[] values = serializer.serialize(value);
                redisConnection.set(keys, values);
                return true;
            }
        });
        expire(key, time);
        return true;
    }

	@Override
	public Boolean hset(final String key, final String field, final String value, Long time) {
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.hSet(
                        getRedisSerializer().serialize(key),
                        getRedisSerializer().serialize(field),
                        getRedisSerializer().serialize(value)
                );
            }
        });
        expire(key, time);
        return true;
    }
    
    
	@Override
	public Boolean expire(final String key, final Long time) {
		if(time > 0) {
			return redisTemplate.execute(new RedisCallback<Boolean>() {
	            @Override
	            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
	                RedisSerializer<String> serializer = getRedisSerializer();
	                byte[] keys = serializer.serialize(key);
	                redisConnection.expire(keys, time);
	                return true;
	            }
	        });
		}
		return true;
	}

    /**
     * 获取主库的redis模板
     *
     * @return
     */
    protected RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }


    /**
     * 获取主库的字符串序列化对象
     *
     * @return
     */
    protected RedisSerializer<String> getRedisSerializer() {
        RedisSerializer<String> redisSerializer = getRedisTemplate().getStringSerializer();
        return redisSerializer;
    }

}
