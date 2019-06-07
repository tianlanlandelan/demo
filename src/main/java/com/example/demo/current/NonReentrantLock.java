package com.example.demo.current;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 基于AQS实现的不可重入的独占锁
 * @author yangkaile
 * @date 2019-06-04 16:33:50
 */
public class NonReentrantLock implements Lock,Serializable {

    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean isHeldExclusively(){
            return getState() == 1;
        }

        /**
         * 因为是不可重入锁，这里的acquires参数应始终为1
         * @param acquires
         * @return
         */
        @Override
        public boolean tryAcquire(int acquires){
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 因为是不可重入锁，这里的releases参数应始终为1
         * @param releases
         * @return
         */
        @Override
        protected boolean tryRelease(int releases){
            if(getState() == 0 || Thread.currentThread() != getExclusiveOwnerThread()){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        ConditionObject newConditionObject(){
            return new ConditionObject() ;
        }
    }

    private final Sync sync = new Sync();

    @Override
    public void lock(){
        sync.acquire(1);
    }

    @Override
    public boolean tryLock(){
        return sync.tryAcquire(1);
    }

    @Override
    public void unlock(){
        sync.release(1);
    }

    @Override
    public Condition newCondition(){
        return sync.newConditionObject();
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException{
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock(long timeout, TimeUnit unit) throws  InterruptedException{
        return sync.tryAcquireNanos(1,unit.toNanos(timeout));
    }

}
