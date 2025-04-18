package fr.eseo.twic.petnkeu.apiserver.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
public class DeptManager {

    // Getters et Setters
    private Integer empNo;
    private String deptNo;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Employees employee;
    private Department department;

    // Constructeurs
    public DeptManager() {
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeptManager DeptManager = (DeptManager) o;
        return Objects.equals(empNo, DeptManager.empNo) &&
                Objects.equals(deptNo, DeptManager.deptNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, deptNo);
    }

    @Override
    public String toString() {
        return "DeptManager{" +
                "empNo=" + empNo +
                ", deptNo='" + deptNo + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
