package org.inventory.management.helpers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// This would be replaced by redis locks in the distributed system
public class LockManager {
    private static final Map<String, Lock> locks = new ConcurrentHashMap<>();

    public static boolean acquireLock(String key) {
        Lock lock = locks.computeIfAbsent(key, k -> new ReentrantLock());
        // Failed to acquire lock
        return lock.tryLock(); // Lock acquired successfully
    }

    public static boolean releaseLock(String key) {
        Lock lock = locks.get(key);
        if (lock != null && lock.tryLock()) {
            try {
                lock.unlock();
                locks.remove(key);
                return true; // Lock released successfully
            } finally {
                lock.unlock();
            }
        } else {
            return false; // Lock not found or failed to release lock
        }
    }
}