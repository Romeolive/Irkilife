package com.example.betaversion_20;



import java.util.HashMap;
import java.util.Map;

public class Arrays {



    public static String[] NUMBERS = {"One","Two","Three","Four"};

    public static String[] LEVELS_NAMES_PEOPLE = {"questionFirstLevel","questionSecondLevel","questionThirdLevel","questionFourLevel",
            "questionFiveLevel","questionSixLevel","questionSevenLevel","questionEightLevel","questionNineLevel",
            "questionTenLevel","questionElevenLevel","questionTwelveLevel"};
    public static String[] ANSWERS_NAMES_PEOPLE = {"answerFirstLevel","answerSecondLevel","answerThirdLevel",
            "answerFourLevel","answerFiveLevel","answerSixLevel","answerSevenLevel","answerEightLevel","answerNineLevel",
            "answerTenLevel","answerElevenLevel","answerTwelveLevel"};
    public static String[] KEY_PEOPLE = {"Акимов Олег","Яков Похабов","Сперанский Михаил Михайлович","Владимир Платонович Сукачев",
            "Муравьев-Амурский Николай Николаевич","Александра Валентиновича Вампилова","Е.А. Евтушенко","Д. Мацуев",
            "Л. И. Гайдай","Д.А.Дмитриева","Б.Волынов","Константин Трапезников"};

    public static String[] LEVELS_NAMES_HISTORY = {"questionFirstHistory","questionSecondHistory","questionThirdHistory","questionFourHistory",
            "questionFiveHistory","questionSixHistory","questionSevenHistory","questionEightHistory","questionNineHistory",
            "questionTenHistory","questionElevenHistory","questionTwelveHistory"};
    public static String[] ANSWERS_NAMES_HISTORY = {"answerFirstHistory","answerSecondHistory","answerThirdHistory","answerThirdHistory",
            "answerThirdHistory","answerSixHistory","answerSevenHistory","answerEightHistory","answerNineHistory",
            "answerTenHistory","answerElevenHistory","answerTwelveHistory"};
    public static String[] KEY_HISTORY = {"1851","16 августа 1898 года","В честь восстания Декабристов 1919 года","1661","Буряты","Тофалары",
            "Рабочие","Тальцы","Ясак","Ангарск","Шаманизм","1937"};

    public static  String[] LEVEL_NAMES_SYMBOLS = {"questionFirstSymbol","questionSecondSymbol","questionThirdSymbol",
            "questionFourSymbol","questionFiveSymbol","questionSixSymbol"};

    public static  String[] ANSWERS_NAMES_SYMBOLS = {"answerFirstSymbol","answerSecondSymbol","answerThirdSymbol",
            "answerFourSymbol","answerFiveSymbol","answerSixSymbol"};

    public static  String[] KEY_SYMBOLS = {"18 февраля 1690 года","Бабр и соболь","Архиерейский дом","Крестовоздвиженская церковь",
    "Михаил Переяславец","Женам Декабристов"};

    public static int COUNTER = 0;
    public static int COUNTER_OF_TRUE = 0;
    public static int HISTORY_COUNTER = 0;
    public static int SYMBOL_COUNTER = 0;

    public static String[] NOTIFICATION_TEXT = {"Не забудьте зайти к нам","Байкал ждет своих героев","Мы скучаем по тебе:)"};


    public static int[] TEXT_VIEW = {R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,
            R.id.point6,R.id.point7, R.id.point8, R.id.point9,R.id.point10,R.id.point11, R.id.point12};
    public static int[] TEXT_VIEW_HISTORY = {R.id.rect1,R.id.rect2,R.id.rect3,R.id.rect4,R.id.rect5,R.id.rect6,
            R.id.rect7,R.id.rect8,R.id.rect9,R.id.rect10,R.id.rect11,R.id.rect12};
    public static int[] TEXT_VIEW_SYMBOL = {R.id.circle1,R.id.circle2,R.id.circle3,R.id.circle4,R.id.circle5,
            R.id.circle6,R.id.circle7,R.id.circle8,R.id.circle9,R.id.circle10,R.id.circle11,R.id.circle12};

    public static int[] IMAGES = {R.drawable.akimov,R.drawable.yakov,R.drawable.speranskuy,R.drawable.sykachev,
            R.drawable.amurckuy,R.drawable.vampilov,R.drawable.evtushenko,R.drawable.mazuev,R.drawable.gyuday,
            R.drawable.dmitrieva,R.drawable.volynov,R.drawable.trapeznickov};
    public static int[] IMAGES_HISTORY = {R.drawable.geog,R.drawable.train,R.drawable.decembers,R.drawable.irkutsk_city,
            R.drawable.byryat,R.drawable.tof,R.drawable.christian,R.drawable.talzy,R.drawable.yasak,R.drawable.angarsk,
            R.drawable.shaman,R.drawable.oblast};


    public static Map<Integer,Integer> MAP_AR = new HashMap<>();




}
