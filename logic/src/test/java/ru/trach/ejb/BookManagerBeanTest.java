package ru.trach.ejb;

import org.junit.Before;
import org.junit.Test;
import ru.trach.domain.BookEntity;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import static org.mockito.Mockito.*;


public class BookManagerBeanTest {

    private  BookEntity bookEntity ;
    private BookManagerBean managerBean;
    private   Query query;

   @Before
    public void setUp(){
            managerBean = new BookManagerBean();
            bookEntity =   mock(BookEntity.class);
            managerBean.entityManager  =  mock(EntityManager.class);
            query = mock(TypedQuery.class);
    }


    @Test
    public void persist_book_test(){

         managerBean.create(bookEntity);

       verify(managerBean.entityManager).persist(bookEntity);
        verifyNoMoreInteractions(managerBean.entityManager,bookEntity);

    }

    @Test
    public void find_all_book_test(){
        when(managerBean.entityManager.createNamedQuery(BookEntity.FIND_ALL,BookEntity.class)).thenReturn((TypedQuery<BookEntity>) query);
        managerBean.findAll();

        verify(managerBean.entityManager).createNamedQuery(BookEntity.FIND_ALL,BookEntity.class);
        verify(query).executeUpdate();
        verify(query).getResultList();
        verifyNoMoreInteractions(query,managerBean.entityManager,bookEntity);

    }

    @Test
    public void remove_book_test(){



        when(managerBean.entityManager.createNamedQuery(BookEntity.REMOVE)).thenReturn(query);

        managerBean.remove(bookEntity);

        verify(managerBean.entityManager).createNamedQuery(BookEntity.REMOVE);
        verify(query).setParameter("id",eq(anyLong()));
        verify(query).executeUpdate();
        verify(bookEntity).getId();
        verifyNoMoreInteractions(query,managerBean.entityManager,bookEntity);
    }
 
}
