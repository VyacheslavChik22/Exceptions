public class Main {
    public static void main(String[] args) {

         boolean result =   Validator.check("Sergey", "D_1hWiKjjP","D_1hWiKjjP");
if(result){
    System.out.println("Пароль и логин корректны!");
}else{
    System.out.println("Пароль и логин не корректны!");
}

    }

}
