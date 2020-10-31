package com.portal.specification;

import com.portal.model.Advertisement;
import com.portal.operationUtils.criteria.SearchCriteria;
import com.portal.operationUtils.SearchOperation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AdSpecification implements Specification<Advertisement> {

    private SearchCriteria criteria;
    private List<SearchCriteria> list;

    public AdSpecification() {
        this.list = new ArrayList<>();
    }

    public AdSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Specification<Advertisement> and(Specification<Advertisement> other) {
        return null;
    }

    @Override
    public Specification<Advertisement> or(Specification<Advertisement> other) {
        return null;
    }

//    @Override
//    public Predicate toPredicate(Root<Advertisement> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//        return criteriaBuilder.like( root.<String>get("ad_code"),"%"+criteria.getUserId()+"%");
//    }


    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Advertisement> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        //create a new predicate list
        List<Predicate> predicates = new ArrayList<>();

        //add add criteria to predicates
        for (SearchCriteria criteria : list) {
            if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                predicates.add(builder.greaterThan(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                predicates.add(builder.lessThan(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(builder.greaterThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(builder.lessThanOrEqualTo(
                        root.get(criteria.getKey()), criteria.getValue().toString()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(builder.notEqual(
                        root.get(criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                if (criteria.getKey().contains("~")) {
                    String[] list = criteria.getKey().split("~");
                    predicates.add(builder.equal(
                            root.get(list[0]).get(list[1]), criteria.getValue()));
                } else {
                    predicates.add(builder.equal(
                            root.get(criteria.getKey()), criteria.getValue()));
                }
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                if (criteria.getKey().contains("~")) {
                    String[] list = criteria.getKey().split("~");
                    predicates.add(builder.like(
                            builder.lower(root.get(list[0]).get(list[1])),
                            "%" + criteria.getValue().toString().toLowerCase() + "%"));
                } else if (criteria.getKey().contains(":")) {
                    String[] list = criteria.getKey().split(":");
                    predicates.add(builder.like(
                            builder.lower(root.get(list[0]).get(list[1]).get(list[2])),
                            "%" + criteria.getValue().toString().toLowerCase() + "%"));
                } else {
                    predicates.add(builder.like(
                            builder.lower(root.get(criteria.getKey())),
                            "%" + criteria.getValue().toString().toLowerCase() + "%"));
                }
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        criteria.getValue().toString().toLowerCase() + "%"));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                predicates.add(builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase()));
            } else if (criteria.getOperation().equals(SearchOperation.IN)) {
                predicates.add(builder.in(root.get(criteria.getKey())).value(criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
                predicates.add(builder.not(root.get(criteria.getKey())).in(criteria.getValue()));
            }
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}

