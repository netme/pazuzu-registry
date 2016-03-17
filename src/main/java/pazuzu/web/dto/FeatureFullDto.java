package pazuzu.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import pazuzu.model.Feature;

public class FeatureFullDto extends FeatureDto {
    @JsonProperty("dependencies")
    private List<FeatureDto> dependencies;

    public static FeatureFullDto makeFull(Feature feature) {
        if (null == feature) {
            return null;
        }
        final FeatureFullDto result = new FeatureFullDto();
        fillShort(feature, result);
        result.dependencies = feature.getDependencies().stream().map(FeatureDto::ofShort).collect(Collectors.toList());
        return result;
    }
}
