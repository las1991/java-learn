package com.las.learn.geektime.concurrentInAction.mutex;

/**
 * @author las
 * @date 19-6-3
 */
public class Account {
    private Allocator allocator = Allocator.AllocatorSingleton.INSTANCE.getInstance();
    // 锁：保护账户余额
    private final Object balLock = new Object();
    // 账户余额
    private Integer balance;
    // 锁：保护账户密码
    private final Object pwLock = new Object();
    // 账户密码
    private String password;


    public Account(Integer balance) {
        this.balance = balance;
    }

    // 取款
    void withdraw(Integer amt) {
        synchronized (this.balLock) {
            if (this.balance > amt) {
                this.balance -= amt;
            }
        }
    }

    // 转账
    void transferDeadLock(Account target, int amt) {
        synchronized (this.balLock) {
            synchronized (target.balLock) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    void transferBlock(Account target, int amt) {
        while (!allocator.applyBlock(this, target)) ;
        try {
            synchronized (this) {
                synchronized (target) {
                    if (this.balance > amt) {
                        this.balance -= amt;
                        target.balance += amt;
                    }
                }
            }
        } finally {
            allocator.free(this, target);
        }
    }

    void transfer(Account target, int amt) {
        Allocator.AllocatorSingleton.INSTANCE.getInstance().apply(this, target);
        this.balance -= amt;
        target.balance += amt;
        Allocator.AllocatorSingleton.INSTANCE.getInstance().free(this, target);
    }


    // 查看余额
    Integer getBalance() {
        synchronized (balLock) {
            return balance;
        }
    }

    // 更改密码
    void updatePassword(String pw) {
        synchronized (pwLock) {
            this.password = pw;
        }
    }

    // 查看密码
    String getPassword() {
        synchronized (pwLock) {
            return password;
        }
    }

}
