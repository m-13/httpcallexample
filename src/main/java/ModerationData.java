import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModerationData {
    @JsonProperty("name")
    private String name;

    @JsonProperty("videoid")
    private String videoId;

    @JsonProperty("videourl")
    private String videoUrl;

    @JsonProperty("reasontype")
    private String reasonType;

    @JsonProperty("reasonsubtype")
    private String reasonSubType;

    @JsonProperty("reason_mitron")
    private String reason;

    // @JsonProperty("status")
    // private String status;

    @JsonProperty("type_of_environment")
    private String typeOfEnvironment;

    // @JsonProperty("_id")
    // private String leadId;

    // @JsonProperty("project_id")
    // private String projectId;
}
