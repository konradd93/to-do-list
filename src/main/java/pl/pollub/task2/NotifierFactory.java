package pl.pollub.task2;

public class NotifierFactory{

    private static final Notifier emailNotifier = new EmailNotifierImpl();
    private static final Notifier mobileNotifier = new MobileNotifier();

    public static Notifier createNotifier(KindOfNotify kindOfNotify) {
        switch(kindOfNotify){
            case EMAIL:
                return emailNotifier;
            case MOBILE:
                return mobileNotifier;
            default: return null;
        }
    }
}
