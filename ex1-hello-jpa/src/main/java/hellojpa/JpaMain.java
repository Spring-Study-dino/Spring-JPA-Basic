package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.Item;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.Orders;

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
            Orders orders = new Orders();
            orders.setMember(member);
            orders.setStatus(OrderStatus.ORDER);
            em.persist(orders);
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(orders);
            orderItem.setItem(item1);
            orderItem.setCount(3);
            em.persist(orderItem);

            em.flush();
            em.clear();
            Orders orders2 = em.find(orders.getClass(), orderItem.getId());
            for (OrderItem orderItem2 : orders2.getOrderItemList()) {
                System.out.println(orderItem2);
            }

            transaction.commit();


        } catch (Exception e) {
        }

        em.close();
        emf.close();
    }
}
