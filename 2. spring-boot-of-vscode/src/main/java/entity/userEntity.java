package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class userEntity {
    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userMobNo;

    @Column(nullable = false)
    private String userSex;

}
