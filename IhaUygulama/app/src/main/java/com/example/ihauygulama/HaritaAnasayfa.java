package com.example.ihauygulama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class HaritaAnasayfa extends AppCompatActivity {

    Button _haritayial;
    public static String il_h;
    public static String tarih_h;
    public static String ilce_h;


    Spinner spinner_iller;
    ArrayAdapter<String> dataAdapter_iller;

    private Spinner spinner_ilceler;
    private ArrayAdapter <String> dataAdapter_ilceler;

    private TextView secili_il;
    private TextView secili_ilce;

    Button selectDate;
    private DatePickerDialog datePickerDialog;
    private TextView dateTxt;
    private Calendar calendar;
    private int year, month, dayOfMonth;
    //Türkiye'ye ait iller
    private final String[] iller={ "Adana","Adıyaman","Afyonkarahisar", "Ağrı", "Aksaray","Amasya","Ankara","Antalya","Ardahan","Artvin","Aydın",
            "Balıkesir", "Bartın","Batman","Bayburt","Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa","Çanakkale", "Çankırı", "Çorum",
            "Denizli", "Diyarbakır","Düzce","Edirne","Elazığ", "Erzincan", "Erzurum", "Eskişehir","Gaziantep", "Giresun", "Gümüşhane","Hakkâri",
            "Hatay", "Iğdır", "Isparta", "İstanbul","İzmir", "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis","Kırıkkale",
            "Kırklareli", "Kırşehir", "Kocaeli","Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu",
            "Osmaniye", "Rize", "Sakarya","Samsun" ,"Şanlıurfa", "Siirt","Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli","Uşak","Van",
            "Yalova" ,"Yozgat" ,"Zonguldak"};

    //Türkiye'ye ait ilçeler
    final private String [] adana_ilce={"Aladağ","Ceyhan","Çukurova","Feke","İmamoğlu","Karaisalı","Karataş","Kozan","Pozantı","Saimbeyli","Sarıçam","Seyhan","Tufanbeyli","Yumurtalık","Yüreğir"};
    final private String [] adiyaman_ilce={"Çelikhan","Gerger","Gölbaşı","Kahta","Merkez", "Samsat", "Sincik", "Tut"};
    final private String [] afyonkarahisar_ilce={"Başmakçı","Bayat","Bolvadin","Çay","Çobanlar","Dazkırı","Dinar","Emirdağ","Evciler","Hocalar","İhsaniye","İscehisar","Kızılören,Merkez","Sandıklı","Sinanpaşa","Şuhut","Sultandağı",};
    final private String [] agri_ilce={ "Diyadin", "Doğubayazıt", "Eleşkirt","Hamur","Merkez", "Patnos" ,"Taşlıçay", "Tutak"};
    final private String [] aksaray_ilce={"Ağaçören", "Eskil", "Gülağaç", "Güzelyurt", "Merkez", "Ortaköy", "Sarıyahşi", "Sultanhanı"};
    final private String [] amasya_ilce={ "Göynücek", "Gümüşhacıköy", "Hamamözü","Merkez", "Merzifon", "Suluova", "Taşova" };
    final private String [] ankara_ilce={"Akyurt", "Altındağ","Ayaş", "Bala", "Beypazarı", "Çamlıdere", "Çankaya", "Çubuk", "Elmadağ","Etimesgut", "Evren","Gölbaşı","Güdül","Haymana", "Kahramankazan", "Kalecik", "Keçiören", "Kızılcahamam", "Mamak", "Nallıhan", "Polatlı", "Pursaklar", "Şereflikoçhisar", "Sincan", "Yenimahalle"};
    final private String [] antalya_ilce={"Akseki","Aksu","Alanya","Demre", "Döşemealtı", "Elmalı", "Finike", "Gazipaşa", "Gündoğmuş", "İbradı", "Kaş", "Kemer", "Kepez", "Konyaaltı", "Korkuteli" ,"Kumluca", "Manavgat", "Muratpaşa", "Serik"};
    final private String [] ardahan_ilce={"Çıldır","Damal","Göle","Hanak","Merkez", "Posof"};
    final private String [] artvin_ilce={"Ardanuç", "Arhavi", "Borçka", "Hopa", "Kemalpaşa", "Merkez", "Murgul", "Şavşat", "Yusufeli"};
    final private String [] aydin_ilce={ "Bozdoğan","Buharkent","Çine","Didim","Efeler","Germencik","İncirliova","Karacasu","Karpuzlu","Koçarlı","Köşk","Kuşadası","Kuyucak","Nazilli", "Söke", "Sultanhisar", "Yenipazar",};
    final private String [] balikesir_ilce={"Altıeylül","Ayvalık","Balya","Bandırma","Bigadiç","Burhaniye","Dursunbey","Edremit","Erdek","Gömeç","Gönen","Havran","İvrindi","Karesi","Kepsut","Manyas" ,"Marmara" ,"Savaştepe" ,"Sındırgı" ,"Susurluk"};
    final private String [] bartin_ilce={"Amasra","Kurucaşile","Merkez","Ulus"};
    final private String[] batman_ilce={"Beşiri", "Gercüş", "Hasankeyf", "Kozluk", "Merkez","Sason"};
    final private String [] bayburt_ilce={"Aydıntepe", "Demirözü","Merkez"};
    final private String [] bilecik_ilce={"Bozüyük", "Gölpazarı", "İnhisar","Merkez", "Osmaneli","Pazaryeri","Söğüt","Yenipazar"};
    final private String [] bingol_ilce={"Adaklı", "Genç", "Karlıova","Kiğı", "Merkez", "Solhan", "Yayladere", "Yedisu"};
    final private String [] bitlis_ilce={"Adilcevaz", "Ahlat", "Güroymak", "Hizan", "Merkez", "Mutki", "Tatvan"};
    final private String [] bolu_ilce={"Dörtdivan", "Gerede", "Göynük", "Kıbrıscık","Mengen", "Merkez", "Mudurnu", "Seben", "Yeniçağa"};
    final private String [] burdur_ilce={"Ağlasun","Burdur","Altınyayla","Bucak","Çavdır", "Çeltikçi", "Gölhisar", "Karamanlı", "Kemer", "Merkez","Tefenni", "Yeşilova",};
    final private String [] bursa_ilce={"Büyükorhan","Gemlik","Harmancık", "İnegöl", "İznik", "Karacabey", "Keles", "Kestel","Mudanya", "Mustafakemalpaşa", "Nilüfer","Orhaneli","Orhangazi", "Osmangazi", "Yenişehir", "Yıldırım",};
    final private String [] canakkale_ilce={ "Ayvacık", "Bayramiç", "Biga", "Bozcaada", "Çan","Eceabat","Ezine","Gelibolu","Gökçeada", "Lapseki","Merkez", "Yenice",};
    final private String [] cankiri_ilce={ "Atkaracalar", "Bayramören", "Çerkeş", "Eldivan", "Ilgaz", "Kızılırmak","Korgun", "Kurşunlu", "Merkez", "Orta", "Şabanözü", "Yapraklı",};
    final private String [] corum_ilce={"Alaca","Bayat", "Boğazkale","Dodurga", "İskilip", "Kargı", "Laçin", "Mecitözü", "Merkez", "Oğuzlar", "Ortaköy", "Osmancık", "Sungurlu", "Uğurludağ",};
    final private String [] denizli_ilce={ "Acıpayam", "Babadağ", "Baklan", "Bekilli", "Beyağaç", "Bozkurt", "Buldan", "Çal", "Çameli", "Çardak", "Çivril", "Güney", "Honaz", "Kale", "Merkezefendi", "Pamukkale", "Sarayköy", "Serinhisar", "Tavas",};
    final private String [] diyarbakir_ilce={"Bağlar","Bismil", "Çermik", "Çınar", "Çüngüş", "Dicle", "Eğil","Ergani", "Hani", "Hazro", "Kayapınar", "Kocaköy", "Kulp", "Lice", "Silvan", "Sur", "Yenişehir",};
    final private String [] duzce_ilce={"Akçakoca", "Çilimli", "Cumayeri", "Gölyaka", "Gümüşova", "Kaynaşlı","Merkez", "Yığılca",};
    final private String [] edirne_ilce={"Enez","Havsa","İpsala", "Keşan", "Lalapaşa", "Meriç", "Merkez", "Süloğlu", "Uzunköprü",};
    final private String [] elazig_ilce={"Ağın", "Alacakaya", "Arıcak", "Baskil", "Karakoçan", "Keban", "Kovancılar", "Maden", "Merkez", "Palu", "Sivrice",};
    final private String [] erzincan_ilce={"Çayırlı", "İliç", "Kemah", "Kemaliye", "Merkez", "Otlukbeli", "Refahiye", "Tercan", "Üzümlü",};
    final private String [] erzurum_ilce={ "Aşkale", "Aziziye", "Çat", "Hınıs", "Horasan", "İspir", "Karaçoban", "Karayazı", "Köprüköy", "Narman", "Oltu","Olur", "Palandöken","Pasinler", "Pazaryolu", "Şenkaya", "Tekman", "Tortum", "Uzundere", "Yakutiye",};
    final private String [] eskisehir_ilce={"Alpu", "Beylikova", "Çifteler", "Günyüzü", "Han", "İnönü", "Mahmudiye", "Mihalgazi","Mihalıççık","Odunpazarı", "Sarıcakaya", "Seyitgazi", "Sivrihisar", "Tepebaşı",};
    final private String [] gaziantep_ilce={"Araban","İslahiye", "Karkamış","Nizip", "Nurdağı","Oğuzeli","Şahinbey","Şehitkamil", "Yavuzeli",};
    final private String [] giresun_ilce={"Alucra","Bulancak","Çamoluk", "Çanakçı", "Dereli", "Doğankent","Espiye","Eynesil","Görele","Güce","Keşap","Merkez","Piraziz","Şebinkarahisar", "Tirebolu", "Yağlıdere",};
    final private String [] gumushane_ilce ={"Kelkit", "Köse", "Kürtün", "Merkez", "Şiran", "Torul"};
    final private String [] hakkari_ilce={"Çukurca", "Derecik", "Merkez", "Şemdinli", "Yüksekova"};
    final private String [] hatay_ilce={"Altınözü", "Antakya", "Arsuz", "Belen", "Defne", "Dörtyol", "Erzin", "Hassa", "İskenderun","Kırıkhan","Kumlu","Payas","Reyhanlı","Samandağ","Yayladağı"};
    final private String [] igdir_ilce={"Aralık","Karakoyunlu","Merkez","Tuzluca"};
    final private String [] isparta_ilce={"Aksu", "Atabey", "Eğirdir", "Gelendost", "Gönen", "Keçiborlu", "Merkez", "Şarkikaraağaç", "Senirkent", "Sütçüler", "Uluborlu", "Yalvaç", "Yenişarbademli"};
    final private String [] istanbul_ilce={"Adalar", "Arnavutköy", "Ataşehir", "Avcılar", "Bağcılar", "Bahçelievler", "Bakırköy", "Başakşehir", "Bayrampaşa", "Beşiktaş", "Beykoz", "Beylikdüzü", "Beyoğlu", "Büyükçekmece", "Çatalca", "Çekmeköy", "Esenler", "Esenyurt", "Eyüpsultan", "Fatih", "Gaziosmanpaşa", "Güngören", "Kadıköy", "Kağıthane", "Kartal", "Küçükçekmece" ,"Maltepe", "Pendik", "Sancaktepe", "Sarıyer", "Şile", "Silivri", "Şişli", "Sultanbeyli", "Sultangazi", "Tuzla", "Ümraniye", "Üsküdar", "Zeytinburnu"};
    final private String [] izmir_ilce={"Aliağa", "Balçova", "Bayındır", "Bayraklı", "Bergama", "Beydağ", "Bornova", "Buca", "Çeşme", "Çiğli","Dikili","Foça", "Gaziemir", "Güzelbahçe", "Karabağlar", "Karaburun", "Karşıyaka", "Kemalpaşa", "Kınık","Kiraz","Konak", "Menderes", "Menemen", "Narlıdere", "Ödemiş", "Seferihisar", "Selçuk", "Tire", "Torbalı", "Urla"};
    final private String [] kahramanmaras_ilce={ "Afşin", "Andırın", "Çağlayancerit", "Dulkadiroğlu", "Ekinözü", "Elbistan", "Göksun", "Nurhak", "Onikişubat", "Pazarcık", "Türkoğlu"};
    final private String [] karabuk_ilce={"Eflani", "Eskipazar", "Merkez", "Ovacık", "Safranbolu", "Yenice"};
    final private String [] karaman_ilce={"Ayrancı", "Başyayla", "Ermenek", "Kazımkarabekir", "Merkez", "Sarıveliler"};
    final private String [] kars_ilce={"Akyaka", "Arpaçay", "Digor", "Kağızman", "Merkez", "Sarıkamış", "Selim", "Susuz"};
    final private String [] kastomonu_ilce={"Abana", "Ağlı", "Araç", "Azdavay", "Bozkurt", "Çatalzeytin", "Cide", "Daday", "Devrekani", "Doğanyurt", "Hanönü", "İhsangazi", "İnebolu", "Küre", "Merkez", "Pınarbaşı", "Şenpazar", "Seydiler", "Taşköprü", "Tosya"};
    final private String [] kayseri_ilce={"Akkışla", "Bünyan", "Develi", "Felahiye", "Hacılar", "İncesu", "Kocasinan", "Melikgazi", "Özvatan", "Pınarbaşı", "Sarıoğlan", "Sarız", "Talas", "Tomarza", "Yahyalı", "Yeşilhisar"};
    final private String [] kilis_ilce={"Elbeyli", "Merkez", "Musabeyli", "Polateli"};
    final private String [] kirikkale_ilce={"Bahşılı", "Balışeyh", "Çelebi", "Delice", "Karakeçili", "Keskin", "Merkez", "Sulakyurt", "Yahşihan"};
    final private String [] kirklareli_ilce= {"Babaeski", "Demirköy", "Kofçaz", "Lüleburgaz", "Merkez", "Pehlivanköy", "Pınarhisar", "Vize"};
    final private String [] kirsehir_ilce={"Akçakent", "Akpınar", "Boztepe", "Çiçekdağı", "Kaman", "Merkez", "Mucur"};
    final private String [] kocaeli_ilce={"Başiskele", "Çayırova", "Darıca", "Derince", "Dilovası", "Gebze", "Gölcük", "İzmit", "Kandıra", "Karamürsel", "Kartepe", "Körfez"};
    final private String [] konya_ilce={"Ahırlı", "Akören", "Akşehir", "Altınekin", "Beyşehir", "Bozkır", "Çeltik", "Cihanbeyli", "Çumra", "Derbent", "Derebucak", "Doğanhisar", "Emirgazi", "Ereğli", "Güneysınır", "Hadim", "Halkapınar", "Hüyük", "Ilgın", "Kadınhanı", "Karapınar", "Karatay", "Kulu", "Meram", "Sarayönü", "Selçuklu", "Seydişehir", "Taşkent", "Tuzlukçu", "Yalıhüyük", "Yunak"};
    final private String [] kutahya_ilce={ "Altıntaş", "Aslanapa", "Çavdarhisar", "Domaniç", "Dumlupınar", "Emet", "Gediz", "Hisarcık", "Merkez", "Pazarlar", "Şaphane", "Simav", "Tavşanlı"};
    final private String [] malatya_ilce={ "Akçadağ", "Arapgir", "Arguvan", "Battalgazi", "Darende", "Doğanşehir", "Doğanyol", "Hekimhan", "Kale", "Kuluncak", "Pütürge", "Yazıhan", "Yeşilyurt"};
    final private String [] manisa_ilce={ "Ahmetli", "Akhisar", "Alaşehir", "Demirci", "Gölmarmara", "Gördes", "Kırkağaç", "Köprübaşı", "Kula", "Salihli", "Sarıgöl", "Saruhanlı", "Şehzadeler", "Selendi", "Soma", "Turgutlu", "Yunusemre"};
    final private String [] mardin_ilce={"Artuklu", "Dargeçit", "Derik", "Kızıltepe", "Mazıdağı", "Midyat", "Nusaybin","Ömerli", "Savur", "Yeşilli"};
    final private String [] mersin_ilce={"Akdeniz", "Anamur","Aydıncık", "Bozyazı", "Çamlıyayla", "Erdemli", "Gülnar", "Mezitli", "Mut", "Silifke", "Tarsus", "Toroslar", "Yenişehir"};
    final private String [] mugla_ilce={"Bodrum", "Dalaman","Datça", "Fethiye", "Kavaklıdere", "Köyceğiz", "Marmaris", "Menteşe", "Milas", "Ortaca", "Seydikemer", "Ula", "Yatağan"};
    final private String [] mus_ilce={"Bulanık", "Hasköy", "Korkut", "Malazgirt", "Merkez", "Varto"};
    final private String [] nevsehir_ilce={"Acıgöl","Avanos", "Derinkuyu","Gülşehir", "Hacıbektaş", "Kozaklı", "Merkez", "Ürgüp"};
    final private String [] nigde_ilce={"Altunhisar", "Bor", "Çamardı", "Çiftlik", "Merkez","Ulukışla"};
    final private String [] ordu_ilce={"Akkuş", "Altınordu","Aybastı", "Çamaş", "Çatalpınar", "Çaybaşı", "Fatsa", "Gölköy","Gülyalı", "Gürgentepe", "İkizce", "Kabadüz","Kabataş", "Korgan", "Kumru", "Mesudiye", "Perşembe", "Ulubey", "Ünye",};
    final private String [] osmaniye_ilce={"Bahçe", "Düziçi", "Hasanbeyli", "Kadirli", "Merkez", "Sumbas", "Toprakkale"};
    final private String [] rize_ilce={"Ardeşen", "Çamlıhemşin", "Çayeli", "Derepazarı", "Fındıklı", "Güneysu", "Hemşin", "İkizdere", "İyidere", "Kalkandere", "Merkez", "Pazar"};
    final private String [] sakarya_ilce={"Adapazarı", "Akyazı", "Arifiye", "Erenler", "Ferizli", "Geyve", "Hendek", "Karapürçek", "Karasu", "Kaynarca","Kocaali","Pamukova", "Sapanca", "Serdivan", "Söğütlü", "Taraklı"};
    final private String [] samsun_ilce={"19 Mayıs", "Alaçam", "Asarcık","Atakum", "Ayvacık","Bafra","Canik","Çarşamba","Havza","İlkadım","Kavak","Ladik","Salıpazarı", "Tekkeköy", "Terme", "Vezirköprü", "Yakakent"};
    final private String [] sanliurfa_ilce={"Akçakale", "Birecik", "Bozova", "Ceylanpınar", "Eyyübiye", "Halfeti", "Haliliye","Harran","Hilvan","Karaköprü","Siverek","Suruç", "Viranşehir"};
    final private String [] siirt_ilce={"Baykan", "Eruh", "Kurtalan", "Merkez", "Pervari", "Şirvan", "Tillo"};
    final private String [] sinop_ilce={"Ayancık", "Boyabat","Dikmen", "Durağan", "Erfelek", "Gerze", "Merkez", "Saraydüzü", "Türkeli"};
    final private String [] sirnak_ilce={ "Beytüşşebap", "Cizre", "Güçlükonak","İdil", "Merkez", "Silopi","Uludere"};
    final private String [] sivas_ilce={"Akıncılar", "Altınyayla", "Divriği", "Doğanşar", "Gemerek", "Gölova", "Gürün", "Hafik", "İmranlı", "Kangal", "Koyulhisar","Merkez", "Şarkışla", "Suşehri" ,"Ulaş", "Yıldızeli", "Zara"};
    final private String [] tekirdag_ilce={"Çerkezköy", "Çorlu", "Ergene", "Hayrabolu", "Kapaklı", "Malkara", "Marmaraereğlisi", "Muratlı", "Saray", "Şarköy", "Süleymanpaşa"};
    final private String [] tokat_ilce={"Almus", "Artova", "Başçiftlik", "Erbaa","Merkez", "Niksar","Pazar","Reşadiye", "Sulusaray", "Turhal", "Yeşilyurt", "Zile"};
    final private String [] trabzon_ilce={"Akçaabat", "Araklı","Arsin", "Beşikdüzü", "Çarşıbaşı","Çaykara", "Dernekpazarı", "Düzköy", "Hayrat", "Köprübaşı", "Maçka", "Of", "Ortahisar","Şalpazarı", "Sürmene", "Tonya", "Vakfıkebir", "Yomra"};
    final private String [] tunceli_ilce={"Çemişgezek", "Hozat", "Mazgirt", "Merkez", "Nazımiye", "Ovacık", "Pertek", "Pülümür"};
    final private String [] usak_ilce={"Banaz", "Eşme", "Karahallı", "Merkez", "Sivaslı", "Ulubey"};
    final private String [] van_ilce={ "Bahçesaray","Başkale", "Çaldıran", "Çatak","Edremit","Erciş", "Gevaş", "Gürpınar", "İpekyolu","Muradiye", "Özalp", "Saray","Tuşba"};
    final private String [] yalova_ilce={"Altınova","Armutlu","Çiftlikköy", "Çınarcık", "Merkez","Termal"};
    final private String [] yozgat_ilce={ "Akdağmadeni", "Aydıncık", "Boğazlıyan", "Çandır", "Çayıralan", "Çekerek" ,"Kadışehri", "Merkez", "Saraykent", "Sarıkaya","Şefaatli", "Sorgun", "Yenifakılı","Yerköy"};
    final private String [] zonguldak_ilce={"Alaplı","Çaycuma","Devrek","Ereğli","Gökçebey","Kilimli","Kozlu","Merkez"};








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harita_anasayfa);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        _haritayial = findViewById(R.id.haritalandirmagoster_button);


        selectDate = findViewById(R.id.selectDate);
        dateTxt = findViewById(R.id.dateTxt);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(HaritaAnasayfa.this,R.style.MyDialogTheme,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                dateTxt.setText(day + "." + (month + 1) + "." + year);
                            }
                        }, year, month, dayOfMonth);
                tarih_h=dateTxt.getText().toString();
                datePickerDialog.show();}


        });

        //il ve ilçe seçimleri

        spinner_iller = (Spinner) findViewById(R.id.il_spinner);
        dataAdapter_iller = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, iller);
        dataAdapter_iller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_iller.setAdapter(dataAdapter_iller);

        spinner_ilceler = (Spinner) findViewById(R.id.ilce_spinner);
        dataAdapter_ilceler = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        dataAdapter_ilceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_ilceler.setAdapter(dataAdapter_ilceler);

        spinner_iller.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if(parent.getSelectedItem().toString().equals(iller[0]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, adana_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[1]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, adiyaman_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[2]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, afyonkarahisar_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[3]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, agri_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[4]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, aksaray_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[5]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, amasya_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[6]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, ankara_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[7]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, antalya_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[8]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, ardahan_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[9]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, artvin_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[10]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, aydin_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[11]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, balikesir_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[12]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, bartin_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[13]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item,batman_ilce );
                else if(parent.getSelectedItem().toString().equals(iller[14]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, bayburt_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[15]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, bilecik_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[16]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, bingol_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[17]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, bitlis_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[18]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, bolu_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[19]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, burdur_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[20]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, bursa_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[21]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, canakkale_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[22]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, cankiri_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[23]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, corum_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[24]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, denizli_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[25]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, diyarbakir_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[26]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, duzce_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[27]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, edirne_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[28]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, elazig_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[29]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, erzincan_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[30]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, erzurum_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[31]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, eskisehir_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[32]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, gaziantep_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[33]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, giresun_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[34]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, gumushane_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[35]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, hakkari_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[36]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, hatay_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[37]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, igdir_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[38]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, isparta_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[39]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, istanbul_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[40]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, izmir_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[41]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, kahramanmaras_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[42]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, karabuk_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[43]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, karaman_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[44]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, kars_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[45]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, kastomonu_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[46]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, kayseri_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[47]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, kilis_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[48]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item,kirikkale_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[49]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, kirklareli_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[50]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, kirsehir_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[51]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, kocaeli_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[52]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, konya_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[53]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, kutahya_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[54]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, malatya_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[55]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, manisa_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[56]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, mardin_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[57]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, mersin_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[58]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, mugla_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[59]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, mus_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[60]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, nevsehir_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[61]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, nigde_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[62]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, ordu_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[63]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, osmaniye_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[64]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, rize_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[65]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, sakarya_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[66]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, samsun_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[67]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, sanliurfa_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[68]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, siirt_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[69]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, sinop_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[70]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, sivas_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[71]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, sirnak_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[72]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, tekirdag_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[73]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, tokat_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[74]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, trabzon_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[75]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, tunceli_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[76]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, usak_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[77]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, van_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[78]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, yalova_ilce);
                else if(parent.getSelectedItem().toString().equals(iller[79]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, yozgat_ilce);
                else if (parent.getSelectedItem().toString().equals(iller[80]))
                    dataAdapter_ilceler = new ArrayAdapter<>(HaritaAnasayfa.this, android.R.layout.simple_spinner_item, zonguldak_ilce);


                dataAdapter_ilceler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_ilceler.setAdapter(dataAdapter_ilceler);

                 il_h=parent.getSelectedItem().toString();
                secili_il = findViewById(R.id.sehirGoster_textView);
                secili_il.setText(il_h);

                spinner_ilceler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                        ilce_h= adapterView.getItemAtPosition(i).toString();
                        secili_ilce = findViewById(R.id.ilcegoster_textView);
                        secili_ilce.setText(ilce_h);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });



            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        _haritayial.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent ucusVeri_sayfasi = new Intent(getApplicationContext(), Harita.class);
                startActivity(ucusVeri_sayfasi);


            }


        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent sayfa_gecis;
        if (id == R.id.ucusverileri) {
            sayfa_gecis = new Intent(getApplicationContext(), UcusVerileriAnasayfa.class);
            startActivity(sayfa_gecis);
        }

        if (id == R.id.anasayfa) {
            sayfa_gecis = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(sayfa_gecis);
        }
        if(id==R.id.harita)
        {
            sayfa_gecis = new Intent(getApplicationContext(), HaritaAnasayfa.class);
            startActivity(sayfa_gecis);
        }
        return true;


    }


}