package cn.sxh.logisticsdemo;

/**
 * @auther snowTiger
 * @mail SnowTigerSong@gmail.com
 * @time 2017/4/13 21:58
 */

public class UserBean {

    /**
     * success : true
     * code : 0
     * reason : 成功
     * time : 0.056
     * result : {"id":104520,"phone":"13612842399","i_type":2,"add_time":1492091102576,"i_count":0}
     */

    private boolean success;
    private int code;
    private String reason;
    private double time;
    private ResultBean result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 104520
         * phone : 13612842399
         * i_type : 2
         * add_time : 1492091102576
         * i_count : 0
         */

        private int id;
        private String phone;
        private int i_type;
        private long add_time;
        private int i_count;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getI_type() {
            return i_type;
        }

        public void setI_type(int i_type) {
            this.i_type = i_type;
        }

        public long getAdd_time() {
            return add_time;
        }

        public void setAdd_time(long add_time) {
            this.add_time = add_time;
        }

        public int getI_count() {
            return i_count;
        }

        public void setI_count(int i_count) {
            this.i_count = i_count;
        }
    }
}
