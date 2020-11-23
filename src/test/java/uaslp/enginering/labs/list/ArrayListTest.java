package uaslp.enginering.labs.list;

import org.junit.jupiter.api.Test;
import uaslp.enginering.labs.model.Student;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArrayListTest {


    @Test
    public void givenNewList_whenSize_thenZeroIsReturned() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        // When:
        int size = arrayList.size();

        // Then:
        assertEquals(0, size);
    }

    @Test
    public void givenNewList_whenAdd_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student student = new Student("Ivan");

        // When:
        arrayList.add(student);

        // Then:
        assertEquals(1, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
    }

    @Test
    public void givenAListWithNoMoreCapacity_whenAdd_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>(2);

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));


        // When:
        arrayList.add(new Student("Francisco"));

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteFirst_thenElementIsDeleted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(0);

        // Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Israel");
        assertEquals(arrayList.getAt(1).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteLast_thenElementIsDeleted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(2);

        // Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
    }

    @Test
    public void givenAListWith3Elements_whenDeleteMiddle_thenElementIsDeleted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(1);

        // Then:
        assertEquals(2, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Francisco");
    }

    /*
    @Test
    public void givenAListWith3Elements_whenDeleteNegative_thenDoesNothing() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(-1);

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
    }


    @Test
    public void givenAListWith3Elements_whenDeleteOutOfSize_thenDoesNothing() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.delete(4);

        // Then:
        assertEquals(3, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
    } */

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningBefore_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");

        arrayList.add(reference);
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Lupita");
        assertEquals(arrayList.getAt(1).getName(), "Ivan");
        assertEquals(arrayList.getAt(2).getName(), "Israel");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndBefore_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(reference);

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Lupita");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleBefore_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Israel");

        arrayList.add(new Student("Ivan"));
        arrayList.add(reference);
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.BEFORE);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Lupita");
        assertEquals(arrayList.getAt(2).getName(), "Israel");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtBeginningAfter_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Ivan");

        arrayList.add(reference);
        arrayList.add(new Student("Israel"));
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Lupita");
        assertEquals(arrayList.getAt(2).getName(), "Israel");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtEndAfter_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Francisco");

        arrayList.add(new Student("Ivan"));
        arrayList.add(new Student("Israel"));
        arrayList.add(reference);

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Francisco");
        assertEquals(arrayList.getAt(3).getName(), "Lupita");
    }

    @Test
    public void givenAListWith3Elements_whenInsertAtMiddleAfter_thenElementIsInserted() {
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Israel");

        arrayList.add(new Student("Ivan"));
        arrayList.add(reference);
        arrayList.add(new Student("Francisco"));

        // When:
        arrayList.insert(reference, new Student("Lupita"), ArrayList.InsertPosition.AFTER);

        // Then:
        assertEquals(4, arrayList.size());
        assertEquals(arrayList.getAt(0).getName(), "Ivan");
        assertEquals(arrayList.getAt(1).getName(), "Israel");
        assertEquals(arrayList.getAt(2).getName(), "Lupita");
        assertEquals(arrayList.getAt(3).getName(), "Francisco");
    }

    @Test
    public void givenEmptyList_whenGetIterator_thenIteratorIsEmpty(){
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        // When:
        ArrayList<Student>.Iterator iterator = arrayList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    @Test
    public void givenListWithOneElement_whenGetIterator_thenIteratorHasOneNext(){
        // Given:
        ArrayList<Student> arrayList = new ArrayList<>();

        arrayList.add(new Student("Ivan"));

        // When:
        ArrayList<Student>.Iterator iterator = arrayList.getIterator();

        // Then:
        assertNotNull(iterator);
        assertTrue(iterator.hasNext());
        Student student = iterator.next();
        assertNotNull(student);
        assertEquals("Ivan", student.getName());
        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    //New Tests

    @Test
    public void GivenATwoStudentsList_WhenDeleteAnInexistentStudent_ThenThrowsAnException(){
        //Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student studentA = new Student("Nero");
        Student studentB = new Student("Virgil");
        Student studentC = new Student("William");

        arrayList.add(studentA);
        arrayList.add(studentB);
        //When:

        //Then:
        assertThatThrownBy(() -> arrayList.delete(studentC)).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void GivenAThreeStudentsList_WhenTheIndexToDeleteIsOutOfRange_ThenThrowsAnException(){
        //Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student studentA = new Student("Nero");
        Student studentB = new Student("Virgil");
        Student studentC = new Student("William");
        int index = 4;

        arrayList.add(studentA);
        arrayList.add(studentB);
        arrayList.add(studentC);

        //When:

        //Then:
        assertThatThrownBy(() -> arrayList.delete(index)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void GivenAThreeStudentsList_WhenASearchedIndexIsOutOfRange_ThenThrowsAnException(){
        //Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student studentA = new Student("Nero");
        Student studentB = new Student("Virgil");
        Student studentC = new Student("William");
        int index = 5;

        arrayList.add(studentA);
        arrayList.add(studentB);
        arrayList.add(studentC);

        //When:

        //Then:
        assertThatThrownBy(() -> arrayList.getAt(index)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    public void GivenAOneStudentList_WhenTheReferenceStudentIsInexistent_ThenThrowsAnException(){
        //Given:
        ArrayList<Student> arrayList = new ArrayList<>();
        Student reference = new Student("Nero");
        Student student = new Student("Virgil");
        Student studentB = new Student("William");

        arrayList.add(studentB);

        //When:

        //Then:
        assertThatThrownBy(() -> arrayList.insert(reference,student,ArrayList.InsertPosition.AFTER)).isInstanceOf(NoSuchElementException.class);
    }
}
