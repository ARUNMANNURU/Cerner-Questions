public class Person
{
    private int personId;
    private String personName;

    public Person(int personId, String personName)
    {
        this.personId = personId;
        this.personName = personName;
    }

    public int getPersonId()
    {
        return personId;
    }

    public String getPersonName()
    {
        return personName;
    }
}
