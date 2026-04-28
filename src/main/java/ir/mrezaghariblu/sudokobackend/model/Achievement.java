package ir.mrezaghariblu.sudokobackend.model;

import ir.mrezaghariblu.sudokobackend.enums.AchievementType;
import javax.persistence.*;

@Entity
@Table(name = "achievements")
public class Achievement {
    @Id
    private String code;

    private String title;
    private String description;
    private String iconUrl;

    @Enumerated(EnumType.STRING)
    private AchievementType type;

    private Integer targetValue;

    // Getters & Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIconUrl() { return iconUrl; }
    public void setIconUrl(String iconUrl) { this.iconUrl = iconUrl; }

    public AchievementType getType() { return type; }
    public void setType(AchievementType type) { this.type = type; }

    public Integer getTargetValue() { return targetValue; }
    public void setTargetValue(Integer targetValue) { this.targetValue = targetValue; }
}
