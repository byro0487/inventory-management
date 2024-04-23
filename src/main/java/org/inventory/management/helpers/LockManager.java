package org.inventory.management.helpers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Manages locks for resources identified by unique keys.
 * This class provides thread-safe methods to acquire and release locks
 * using a ConcurrentHashMap. Each key in the map corresponds to a unique resource.
 * This implementation is intended as a placeholder and should be replaced with
 * a distributed lock system (e.g., Redis locks) in a distributed environment.
 */
public class LockManager {
    private static final Map<String, Lock> locks = new ConcurrentHashMap<>();
    /**
     * Attempts to acquire a lock for the specified key.
     * If the lock does not exist, it is created.
     *
     * @param key the key representing the lock
     * @return true if the lock was successfully acquired, false otherwise
     */
    public static boolean acquireLock(String key) {
        Lock lock = locks.computeIfAbsent(key, k -> new ReentrantLock());
        // Failed to acquire lock
        return lock.tryLock(); // Lock acquired successfully
    }
    /**
     * Attempts to release the lock associated with the specified key.
     * If the lock is currently held, it will be released and removed from the map.
     *
     * @param key the key representing the lock
     * @return true if the lock was successfully released, false if the lock was not found
     *         or if the lock could not be released (e.g., not held by the current thread)
     */
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