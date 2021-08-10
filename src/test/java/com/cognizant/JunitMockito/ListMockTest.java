package com.cognizant.JunitMockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class ListMockTest {
    @Mock
    List<String> listMock = mock(List.class);
    @Test
    public void size_basic(){
        when(listMock.size()).thenReturn(5);
        assertEquals(5,listMock.size());
    }
    @Test
    public void returnDifferentValues(){
        when(listMock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5,listMock.size());
        assertEquals(10,listMock.size());

    }
    @Test
    public void returnWithParameters(){
        when(listMock.get(0)).thenReturn("mockito learning");
        assertEquals("mockito learning",listMock.get(0));
        assertEquals(null,listMock.get(1));
    }
    @Test
    public void returnWithGenericParameters(){
        when(listMock.get(anyInt())).thenReturn("mockito learning");
        assertEquals("mockito learning",listMock.get(0));
        assertEquals("mockito learning",listMock.get(1));
    }
    @Test
    public void verifyMethodCall(){
        String value1 = listMock.get(0);
        String value2 = listMock.get(0);
//        verify(listMock).get(anyInt());
        verify(listMock,times(2)).get(0);
        verify(listMock,atLeastOnce()).get(0);
        verify(listMock,atMost(2)).get(0);
        verify(listMock,never()).get(2);
    }
    @Test
    public void argumentCapturing(){
        listMock.add("SomeString");
        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock).add(captor.capture());
        assertEquals("SomeString",captor.getValue());
    }
    @Test
    public void multipleArgumentCapturing(){
        listMock.add("SomeString1");
        listMock.add("SomeString2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(listMock,times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2",allValues.get(1));
    }
    @Test
    public void mocking(){
        //in mocking we lost the actual behavior of class
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.size());
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());

    }
    @Test
    public void Spying(){
        //when we create a mock, we lost the actual behavior of class or interface
        //a mock doesn't retain the behavior of the class
        //a spy retains the default behaviour of the class, spy uses the real class
        ArrayList arrayListSpy = spy(ArrayList.class);
        System.out.println(arrayListSpy.size());
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());
        arrayListSpy.add("Test3");
        System.out.println(arrayListSpy.size());

    }

}
