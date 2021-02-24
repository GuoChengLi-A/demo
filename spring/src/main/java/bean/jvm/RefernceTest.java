package bean.jvm;

/**
 * @Description: TODO
 * @Author: GCL
 * @Date: 2021/2/24 14:31
 */
public class RefernceTest {
    static class SysUser {
        private String userName;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Override
        public String toString() {
            return "SysUser{" +
                    "userName='" + userName + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("gcl");

        SysUser currentUser = sysUser;
        System.out.println(sysUser);
        System.out.println(currentUser);

//        sysUser = new SysUser();
        sysUser.setUserName("yc");
        System.out.println(sysUser);
        System.out.println(currentUser);
    }
}
