import java.util.*
import kotlin.system.exitProcess

var scanner = Scanner(System.`in`)
var old = 123
var input = 0
val wrongTime = 3
var total = 1000

fun main() {

    println("**************************")
    println("    欢迎使用建设银行系统      ")
    println("**************************")

    print("请输入密码：")
    for (i in 1..wrongTime){
        input = scanner.nextInt()
        if (input == old){
            println("密码正确！")
            break
        }
        if (i == wrongTime){
            println("密码次数过多")
            exitProcess(0)
        }
        print("密码输入不正确（剩余次数 ${wrongTime-i})，请重新输入：")
    }

    // 接受用户选择
    var choice: Int
    var isGoon: Char
    while (true) {
        println(" ")
        print("*****************************\n");
        print("1.存款\n");
        print("2.取款\n");
        print("3.查询\n");
        print("4.更改密码\n");
        print("5.退出\n");
        print("*****************************\n");

        print("请选择操作：")
        choice = scanner.nextInt()

        when (choice) {
            1 -> inMoney()
            2 -> outMoney()
            3 -> cheak()
            4 -> changePWD()
            5 -> exitProcess(0)
            else -> println("输入指令有误，请重新输入")
        }
    }

}

fun inMoney(){
    print("请输入存款金额：")
    var temp = scanner.nextInt()
    total += temp
    print("存款成功,当前余额$total")
}

fun outMoney(){
    print("请输入取款金额：")
    var temp = scanner.nextInt()
    // total = if(temp > total) total - temp else total
    if (temp > total){
        print("当前金额不足！")
    } else{
        total -= temp
        print("取款成功，当前金额$total")
    }
}

fun cheak(){
    print("当前余额$total")
}

fun changePWD(){
    var n1: Int
    var n2: Int
    while (true){
        print("请输入密码：")
        n1 = scanner.nextInt()
        print("请确认密码：")
        n2 = scanner.nextInt()
        //old = if (n1 == n2) n1 else old
        if (n1 == n2){
            print("密码设置成功")
            old = n1
            break
        } else{
            print("两次密码输入不正确，请重新更改密码：")
        }
    }
}