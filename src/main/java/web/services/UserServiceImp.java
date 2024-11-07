package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @EventListener(ContextRefreshedEvent.class)
   @Transactional
   public void init() {
      add(new User("User1", "Lastname1", "user1@mail.ru"));
      add(new User("User2", "Lastname2", "user2@mail.ru"));
      add(new User("User3", "Lastname3", "user3@mail.ru"));
      add(new User("User4", "Lastname4", "user4@mail.ru"));
   }

   @Transactional
   @Override
   public void delete(User user) {
      userDao.delete(user);
   }

   @Transactional
   @Override
   public void edit(User user) {;
      userDao.edit(user);
   }

   @Transactional
   @Override
   public User getUser(Long id) {
      return userDao.getUser(id);
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getListUsers() {
      return userDao.getListUsers();
   }
}
