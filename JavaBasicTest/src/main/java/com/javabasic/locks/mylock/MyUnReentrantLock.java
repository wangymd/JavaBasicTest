package com.javabasic.locks.mylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义不可重入排它锁
 * @author win7
 *
 */
public class MyUnReentrantLock implements Lock, java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final Sync sync;

	public MyUnReentrantLock() {
		sync = new Sync();
	}

	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		sync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(0);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return sync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		 return sync.newCondition();
	}
	
	static class Sync extends AbstractQueuedSynchronizer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//判断锁是否已被持有
		@Override
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}

		//如果state为0，尝试获取锁
		@Override
		protected boolean tryAcquire(int arg) {
			assert arg == 0;
			if(compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		//如果state为1，尝试释放锁
		@Override
		protected boolean tryRelease(int arg) {
			assert arg == 1;
			if(getState() == 0) throw new IllegalMonitorStateException();
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
		
        public ConditionObject newCondition() {
            return new ConditionObject();
        }
	}
}
