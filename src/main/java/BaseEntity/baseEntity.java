package BaseEntity;


import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class baseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "time_recorded", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeRecorded;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimeRecorded() {
        return timeRecorded;
    }

    public void setTimeRecorded(Date timeRecorded) {
        this.timeRecorded = timeRecorded;
    }
}