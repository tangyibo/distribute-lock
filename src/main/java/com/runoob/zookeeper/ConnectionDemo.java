package com.runoob.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;


public class ConnectionDemo {

    public static void main(String[] args) {
        try {
            final CountDownLatch countDownLatch=new CountDownLatch(1);
            ZooKeeper zooKeeper=
                    new ZooKeeper("192.168.3.33:2181," +
                            "192.168.3.35:2181,192.168.3.37:2181",
                            4000, new Watcher() {
                        @Override
                        public void process(WatchedEvent event) {
                            if(Event.KeeperState.SyncConnected==event.getState()){
                                //如果收到了服务端的响应事件，连接成功
                                countDownLatch.countDown();
                            }
                        }
                    });
            countDownLatch.await();
            //CONNECTED
            System.out.println(zooKeeper.getState());
            //添加节点
            zooKeeper.create("/runoob","0".getBytes(),ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
           e.printStackTrace();
        }
    }
}
