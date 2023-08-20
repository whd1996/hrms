import java.util.ArrayList;

// 存款类
class Deposit {
    private String cardNo;  // 用户卡号
    private String password;  // 用户密码
    private int depositAmount;  // 存款金额

    // 构造函数
    public Deposit(String cardNo, String password, int depositAmount) {
        this.cardNo = cardNo;
        this.password = password;
        this.depositAmount = depositAmount;
    }

    // 验证卡号和密码是否正确
    public boolean validate(String cardNo, String password) {
        return this.cardNo.equals(cardNo) && this.password.equals(password);
    }

    // 存款操作
    public boolean deposit(int currentAmount, int maxAmount) {
        // 检查存款金额是否合理
        if (depositAmount % 100 != 0 || depositAmount > 10000) {
            return false;
        }

        // 检查存款张数是否超过100
        if (depositAmount / 100 > 100) {
            return false;
        }

        // 检查存款总额是否超过存取款机上限
        if (currentAmount + depositAmount > maxAmount) {
            return false;
        }

        // 存款操作
        return true;
    }
}

// 取款类
class Withdraw {
    private int withdrawAmount;  // 取款金额

    // 构造函数
    public Withdraw(int withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    // 取款操作
    public boolean withdraw(int currentAmount) {
        // 检查取款金额是否合理
        if (withdrawAmount % 100 != 0) {
            return false;
        }

        // 检查余额是否足够
        if (withdrawAmount > currentAmount) {
            return false;
        }

        // 取款操作
        return true;
    }
}

// 管理员类
class Admin {
    private String password;  // 管理员密码

    // 构造函数
    public Admin(String password) {
        this.password = password;
    }

    // 验证管理员密码是否正确
    public boolean validate(String password) {
        return this.password.equals(password);
    }
}

// 用户类
class User {
    private String cardNo;  // 用户卡号
    private String password;  // 用户密码

    // 构造函数
    public User(String cardNo, String password) {
        this.cardNo = cardNo;
        this.password = password;
    }

    // 验证卡号和密码是否正确
    public boolean validate(String cardNo, String password) {
        return this.cardNo.equals(cardNo) && this.password.equals(password);
    }
}

// 存取款机类
class ATM {
    private int currentAmount;  // 存取款机内的余额
    private int maxAmount;  // 存取款机存款金额的上限
    private Admin admin;  // 管理员对象
    private ArrayList<User> users;  // 用户对象列表

    // 构造函数
    public ATM(int currentAmount, int maxAmount, Admin admin, ArrayList<User> users) {
        this.currentAmount = currentAmount;
        this.maxAmount = maxAmount;
        this.admin = admin;
        this.users = users;
    }

    // 存款操作
    public boolean deposit(String cardNo, String password, int depositAmount) {
        // 验证用户卡号和密码是否正确
        boolean userValid = false;
        for (User user : users) {
            if (user.validate(cardNo, password)) {
                userValid = true;
                break;
            }
        }
        if (!userValid) {
            return false;
        }

        // 存款操作
        Deposit deposit = new Deposit(cardNo, password, depositAmount);
        if (deposit.deposit(currentAmount, maxAmount)) {
            currentAmount += depositAmount;
            return true;
        } else {
            return false;
        }
    }

    // 取款操作
    public boolean withdraw(int withdrawAmount) {
        // 检查是否有足够的余额
        Withdraw withdraw = new Withdraw(withdrawAmount);
        if (withdraw.withdraw(currentAmount)) {
            currentAmount -= withdrawAmount;
            return true;
        } else {
            return false;
        }
    }

    // 管理员登录
    public boolean adminLogin(String password) {
        return admin.validate(password);
    }

    // 管理员存钱操作
    public boolean adminDeposit(int depositAmount) {
        // 检查存款金额是否合理
        if (depositAmount % 100 != 0 || depositAmount > 10000) {
            return false;
        }

        // 检查存款张数是否超过100
        if (depositAmount / 100 > 100) {
            return false;
        }

        // 存款操作
        currentAmount += depositAmount;
        return true;
    }

    // 获取当前余额
    public int getCurrentAmount() {
        return currentAmount;
    }

    // 获取存款上限
    public int getMaxAmount() {
        return maxAmount;
    }
}

public class Test {
    public static void main(String[] args) {
        User user = new User("1000", "abc");
        User user1 = new User("1000", "abc");
        Admin admin = new Admin("admin");
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        ATM atm = new ATM(10000, 10000, admin, userList);
        if (user.validate("1000", "abc")) {
            System.out.println("用户1000登录成功！");
        }
    }
}
