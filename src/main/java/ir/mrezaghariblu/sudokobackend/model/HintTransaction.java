package ir.mrezaghariblu.sudokobackend.model;

import ir.mrezaghariblu.sudokobackend.enums.HintSource;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hint_transactions")
class HintTransaction {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private HintSource source;  // AD_REWARD, PURCHASE, INITIAL

    private int amount;  // +1 یا -1
    private String adToken;  // اگه از تبلیغ بود

    private LocalDateTime createdAt;
}
