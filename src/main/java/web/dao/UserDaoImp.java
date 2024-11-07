package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public List<User> getListUsers() {
      TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
      return query.getResultList();
   }

   @Override
   public void delete(User user) {
      User managedUser = entityManager.contains(user) ? user : entityManager.find(User.class, user.getId());
      if (managedUser != null) {
         entityManager.remove(managedUser);
      }
   }

   @Override
   public void edit(User user) {
      entityManager.merge(user);
   }

   @Override
   public User getUser(Long id) {
      return entityManager.find(User.class, id);
   }
}
