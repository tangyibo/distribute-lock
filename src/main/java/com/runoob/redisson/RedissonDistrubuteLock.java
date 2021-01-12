package com.runoob.redisson;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonDistrubuteLock {

	/**
	 *  参考教程：https://www.cnblogs.com/cjsblog/p/9831423.html
	 * @param args
	 */
	public static void main(String[] args) {
		String taskId = "121";

		Config config = new Config();
		// config.useClusterServers().setScanInterval(2000).addNodeAddress("redis://172.17.207.161:6379")
		config.useSingleServer().setAddress("redis://172.17.207.161:6379").setPassword("6qe@^xd0");

		RedissonClient redisson = Redisson.create(config);
		RLock lock = redisson.getLock("task_" + taskId);

		try {
			boolean res = lock.tryLock(10, TimeUnit.SECONDS);
			if (res) {
				System.out.println("hello world!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
