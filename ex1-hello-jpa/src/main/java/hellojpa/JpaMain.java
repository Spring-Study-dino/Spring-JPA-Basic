package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.Order;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try {
            Member member = new Member();
            member.setName("m1");
            em.persist(member);
            Item item1 = new Item();
            item1.setName("i1");
            em.persist(item1);
            Order order = new Order();
            order.setMember(member);
            order.setStatus(OrderStatus.ORDER);
            em.persist(order);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setItem(item1);
            orderItem.setCount(3);
            em.persist(orderItem);

            em.flush();
            em.clear();
            Order order2 = em.find(order.getClass(), orderItem.getId());
            for (OrderItem orderItem2 : order2.getOrderItemList()) {
                System.out.println(orderItem2);
            }

            transaction.commit();


        } catch (Exception e) {
        }

        em.close();
        emf.close();
    }
}
