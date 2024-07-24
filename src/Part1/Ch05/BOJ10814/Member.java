package Part1.Ch05.BOJ10814;

public class Member implements Comparable<Member>{
    int n;
    int age;
    String name;

    public Member() {
    }

    public Member(int n, int age, String name) {
        this.n = n;
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Member o) {
        if(age == o.age) // 나이가 같으면
            return n - o.n;
        return age - o.age;
    }
}
