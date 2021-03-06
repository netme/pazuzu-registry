package org.zalando.pazuzu.feature;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FeatureRepository extends CrudRepository<Feature, Integer>, FeatureRepositoryCustom {

    List<Feature> findByNameIgnoreCaseContaining(String name);

    Optional<Feature> findByName(String name);

    Set<Feature> findByNameIn(Set<String> name);

    List<Feature> findByDependenciesContaining(Feature feature);
}
