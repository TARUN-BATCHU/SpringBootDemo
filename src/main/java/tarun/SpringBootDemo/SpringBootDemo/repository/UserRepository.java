package tarun.SpringBootDemo.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

//    public void updateUser(String UserId, User user)
//    {
//        for(int i=0;i<2;i++)
//        {
//            User u = useraa.get(i);
//            if(u.getUserId().equals(UserId))
//            {
//                useraa.set(i,user);
//                return;
//            }
//
//        }
//    }
}
