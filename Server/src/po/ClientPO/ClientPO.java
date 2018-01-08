package po.ClientPO;

import javax.persistence.*;

import po.UserPO.UserPO;

import java.io.Serializable;

@Entity
@Table(name="clientpo")
public class ClientPO implements Serializable{
    private static final long serialVersionUID=1L;
    public ClientPO() {
        
    }

    private int id;
    private String type;
    private String level;
    private String name;
    private String tel;
    private String address;
    private String postcode;
    private String email;
    private double credit;
    private double recieve;
    private double pay;
    private UserPO operator;
    private String isValid;
    private int point;

    public ClientPO(String name, String level, String type, String tel, String address, String postcode, String email, int point) {
        this.name = name;
        this.level = level;
        this.type = type;
        this.tel = tel;
        this.address = address;
        this.postcode = postcode;
        this.email = email;
        this.point = point;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "postcode")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "credit")
    public double getAmount() {
        return credit;
    }

    public void setAmount(double credit) {
        this.credit = credit;
    }

    @Column(name = "recieve")
    public double getRecieve() {
        return recieve;
    }

    public void setRecieve(double recieve) {
        this.recieve = recieve;
    }

    @Column(name = "pay")
    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @ManyToOne
    @JoinColumn(name = "operatorId")
    public UserPO getOperator() {
        return operator;
    }

    public void setOperator(UserPO user) {
        this.operator = user;
    }

    @Column(name = "isValid")
    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    @Column(name = "point")
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
