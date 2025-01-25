package org.diplom.NeedfullThings.model.users;

public enum Cities {
    Moscow("Москва"), Saint_Petersburg("Санкт-Петербург"),
    Sevastopol("Севастополь"), Birobidjan("Биробиджан"),
    Chukotka("Чукотка"), Naryan_Mar("Нарьян-Мар"), Khanty_mansiysk("Ханты-Мансийск"),
    Salehard("Салехард"), Blagovaschensk("Благовещенск"), Arkhangelsk("Архангельск"),
    Astrakhan("Астрахань"), Bryansk("Брянск"),
    Vladimir("Владимир"), Volgograd("Волгоград"), Vologda("Вологда"),
    Voronezh("Воронеж"), Ivanovo("Иваново"), Irkutsk("Иркутск"),
    Koenigsberg("Калининград"), Kaluga("Калуга"), Kemerovo("Кемерово"),
    Kirov("Киров"), Kostroma("Кострома"), Kurgan("Курган"), Kursk("Курск"),
    Lipetsk("Липецк"), Magadan("Магадан"), Murmansk("Мурманск"),
    Nizhny_Novgorod("Нижний Новгород"), Veliky_Novgorod("Великий Новгород"),
    Novosibirsk("Новосибирск"), Omsk("Омск"), Orenburg("Оренбург"), Orel("Орёл"), Penza("Пенза"),
    Pskov("Псков"), Rostov_na_Donu("Ростов-На-Дону"), Ryazan("Рязань"),
    Samara("Самара"), Saratov("Саратов"), Yuzhno_Sakhalinsk("Южно-Сахалинск"),
    Ekaterinburg("Екатеринбург"), Smolensk("Смоленск"), Tambov("Тамбов"),
    Tver("Тверь"), Tomsk("Томск"), Tula("Тула"), Tyumen("Тюмень"), Ulyanovsk("Ульяновск"),
    Chelyabinsk("Челябинск"), Yaroslavl("Ярославль");

    private final String name;

    private Cities(String name){
        this.name = name;
    }

    public String get() {
        return name;
    }

}
