package org.example.repositories;

import org.example.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    private final EntityManager entityManager;

    private int operationsCount = 0;

    public UserRepository(final EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<User> findByNames(String username1, String username2, String email){
        // SELECT FROM users WHERE username = 'mine' OR username = 'yours' OR email = hers@hers.com;

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("username"), username1));
        predicates.add(criteriaBuilder.equal(root.get("username"), username2));
        predicates.add(criteriaBuilder.equal(root.get("mail"), email));

        Predicate whereClause = (criteriaBuilder.or(predicates.toArray(new Predicate[0])));

        CriteriaQuery<User> finalQuery = criteriaQuery.select(root).where(whereClause);

        return entityManager.createQuery(finalQuery).getResultList();

    }

    public User add(User user){
        entityManager.persist(user);
        return user;
    }
}
