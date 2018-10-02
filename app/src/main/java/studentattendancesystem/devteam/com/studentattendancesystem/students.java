package studentattendancesystem.devteam.com.studentattendancesystem;

public class students {
    private int mid ;
    private String mstudent_id;
    private String mStudentNmae;


    public students(String student_id, String StudentName) {
        this.mstudent_id = student_id;
        this.mStudentNmae = StudentName;

    }

    public String getmStudentNmae() {
        return mStudentNmae;
    }

    public void setmStudentNmae(String mStudentNmae) {
        this.mStudentNmae = mStudentNmae;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public void setMstudent_id(String mstudent_id) {
        this.mstudent_id = mstudent_id;
    }

    public int getMid() {
        return mid;
    }

    public String getMstudent_id() {
        return mstudent_id;
    }
}
