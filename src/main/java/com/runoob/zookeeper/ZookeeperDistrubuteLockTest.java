package com.runoob.zookeeper;

import java.io.IOException;
import com.runoob.zklock.PandaLockException;
import com.runoob.zklock.ZookeeperDistributedLock;

public class ZookeeperDistrubuteLockTest {

	public static void main(String[] args) throws IOException, InterruptedException, PandaLockException {
		for (int i = 0; i < 10; i++) {
			new Thread() {
				public void run() {
					try {
						ZookeeperDistributedLock locker = new ZookeeperDistributedLock();
						locker.connectZooKeeper("172.17.207.244:12181", "jason");
						try {
							locker.lock();
							System.out.println(Thread.currentThread().getName() + "在做事，做完就释放锁");
							Thread.sleep(1000);
							System.out.println(Thread.currentThread().getName() + "我做完事情了");
						} finally {
							locker.releaseLock();
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();
		}
	}

}
