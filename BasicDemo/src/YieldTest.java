public class YieldTest extends Thread {  
  
    public YieldTest(String name) {  
        super(name);  
    }  
  
    @Override  
    public void run() {  
        for (int i = 1; i <= 50; i++) {  
            System.out.println("" + this.getName() + "-----" + i);  
            // ��iΪ30ʱ�����߳̾ͻ��CPUʱ���õ��������������Լ����߳�ִ�У�Ҳ����˭������˭ִ�У�  
            if (i == 30) {  
                this.yield();  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        YieldTest yt1 = new YieldTest("����");  
        YieldTest yt2 = new YieldTest("����");  
        yt1.start();  
        yt2.start();  
    }  
}  