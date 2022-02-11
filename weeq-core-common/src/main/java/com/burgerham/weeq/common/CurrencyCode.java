package com.burgerham.weeq.common;

import java.util.Currency;
import lombok.Getter;


/**
 * http://www.xe.com/iso4217.php#S
 */
@Getter
public enum CurrencyCode {
  AED("United Arab Emirates Dirham", "د.إ.\u200F"),
  AFN("Afghan Afghani", "؋"),
  ALL("Albanian Lek", "Lek"),
  AMD("Armenian Dram", "դր."),
  ANG("Netherlands Antillean Guilder", "ANG"),
  AOA("Angolan Kwanza", "Kz"),
  ARS("Argentine Peso", "$"),
  AUD("Australian Dollar", "$"),
  AWG("Aruban Florin", "Afl."),
  AZN("Azerbaijani Manat", "ман."),
  BAM("Bosnia-Herzegovina Convertible Mark", "KM"),
  BBD("Barbadian Dollar", "$"),
  BDT("Bangladeshi Taka", "৳"),
  BGN("Bulgarian Lev", "лв."),
  BHD("Bahraini Dinar", "د.ب."),
  BIF("Burundian Franc", "FBu"),
  BMD("Bermudan Dollar", "$"),
  BND("Brunei Dollar", "$"),
  BOB("Bolivian Boliviano", "Bs"),
  BRL("Brazilian Real", "R$"),
  BSD("Bahamian Dollar", "BSD"),
  BTN("Bhutanese Ngultrum", "BTN"),
  BWP("Botswanan Pula", "P"),
  BYN("Belarusian Ruble", "BYR"),
  BYR("Belarusian Ruble (2000-2016)", "BYR"),
  BZD("Belize Dollar", "$"),
  CAD("Canadian Dollar", "$"),
  CDF("Congolese Franc", "FrCD"),
  CHF("Swiss Franc", "CHF"),
  CLF("Chilean Unit of Account (UF)", "$"),
  CLP("Chilean Peso", "$"),
  CNY("Chinese Yuan", "CN¥"),
  COP("Colombian Peso", "$"),
  CRC("Costa Rican Colón", "₡"),
  CUC("Cuban Convertible Peso", "CUC"),
  CUP("Cuban Peso", "CUP"),
  CVE("Cape Verdean Escudo", "CVE"),
  CZK("Czech Republic Koruna", "Kč"),
  DJF("Djiboutian Franc", "Fdj"),
  DKK("Danish Krone", "kr"),
  DOP("Dominican Peso", "DOP"),
  DZD("Algerian Dinar", "د.ج.\u200F"),
  EGP("Egyptian Pound", "ج.م.\u200F"),
  ERN("Eritrean Nakfa", "Nfk"),
  ETB("Ethiopian Birr", "ብር"),
  EUR("Euro", "€"),
  FJD("Fijian Dollar", "FJD"),
  FKP("Falkland Islands Pound", "FKP"),
  GBP("British Pound Sterling", "£"),
  GEL("Georgian Lari", "GEL"),
  GHS("Ghanaian Cedi", "GHS"),
  GIP("Gibraltar Pound", "GIP"),
  GMD("Gambian Dalasi", "GMD"),
  GNF("Guinean Franc", "FG"),
  GTQ("Guatemalan Quetzal", "Q"),
  GYD("Guyanaese Dollar", "GYD"),
  HKD("Hong Kong Dollar", "$"),
  HNL("Honduran Lempira", "L"),
  HRK("Croatian Kuna", "kn"),
  HTG("Haitian Gourde", "HTG"),
  HUF("Hungarian Forint", "Ft"),
  IDR("Indonesian Rupiah", "Rp"),
  ILS("Israeli New Sheqel", "₪"),
  INR("Indian Rupee", "₹"),
  IQD("Iraqi Dinar", "د.ع."),
  IRR("Iranian Rial", "﷼"),
  ISK("Icelandic Króna", "kr"),
  JMD("Jamaican Dollar", "$"),
  JOD("Jordanian Dinar", "د.أ."),
  JPY("Japanese Yen", "￥"),
  KES("Kenyan Shilling", "Ksh"),
  KGS("Kyrgystani Som", "KGS"),
  KHR("Cambodian Riel", "៛"),
  KMF("Comorian Franc", "CF"),
  KPW("North Korean Won", "KPW"),
  KRW("South Korean Won", "₩"),
  KWD("Kuwaiti Dinar", "د.ك."),
  KYD("Cayman Islands Dollar", "KYD"),
  KZT("Kazakhstani Tenge", "₸"),
  LAK("Laotian Kip", "LAK"),
  LBP("Lebanese Pound", "ل.ل."),
  LKR("Sri Lankan Rupee", "රු."),
  LRD("Liberian Dollar", "$"),
  LSL("Lesotho Loti", "LSL"),
  LTL("Lithuanian Litas", "Lt"),
  LVL("Latvian Lats", "Ls"),
  LYD("Libyan Dinar", "د.ل."),
  MAD("Moroccan Dirham", "د.م."),
  MDL("Moldovan Leu", "MDL"),
  MGA("Malagasy Ariary", "MGA"),
  MKD("Macedonian Denar", "ден."),
  MMK("Myanma Kyat", "K"),
  MNT("Mongolian Tugrik", "MNT"),
  MOP("Macanese Pataca", "MOP"),
  MRO("Mauritanian Ouguiya", "MRO"),
  MUR("Mauritian Rupee", "MUR"),
  MVR("Maldivian Rufiyaa", "MVR"),
  MWK("Malawian Malawi Kwacha", "MWK"),
  MYR("Malaysian Ringgit", "RM"),
  MXN("Mexican Peso", "$"),
  MZN("Mozambican Metical", "MTn"),
  NAD("Namibian Dollar", "$"),
  NGN("Nigerian Naira", "₦"),
  NIO("Nicaraguan Córdoba", "C$"),
  NOK("Norwegian Krone", "kr"),
  NPR("Nepalese Rupee", "नेरू"),
  NZD("New Zealand Dollar", "$"),
  OMR("Omani Rial", "ر.ع."),
  PAB("Panamanian Balboa", "B/."),
  PEN("Peruvian Nuevo Sol", "S/."),
  PGK("Papua New Guinean Kina", "PGK"),
  PHP("Philippine Peso\"", "₱"),
  PKR("Pakistani Rupee", "₨"),
  PLN("Polish Zloty", "zł"),
  PYG("Paraguayan Guarani", "₲"),
  QAR("Qatari Rial", "ر.ق.\u200F"),
  RON("Romanian Leu", "RON"),
  RSD("Serbian Dinar", "дин."),
  RUB("Russian Ruble", "₽"),
  RWF("Rwandan Franc", "FR"),
  SAR("Saudi Riyal", "ر.س.\u200F"),
  SBD("Solomon Islands Dollar", "SBD"),
  SCR("Seychellois Rupee", "SCR"),
  SDG("Sudanese Pound", "SDG"),
  SEK("Swedish Krona", "kr"),
  SGD("Singapore Dollar", "$"),
  SHP("Saint Helena Pound", "SHP"),
  SLL("Sierra Leonean Leone", "SLL"),
  SOS("Somali Shilling", "SOS"),
  SRD("Surinamese Dollar", "SRD"),
  SSP("South Sudanese Pound", "SSP"),
  STD("São Tomé and Príncipe Dobra", "STD"),
  SVC("Salvadoran Colón", "SVC"),
  SYP("Syrian Pound", "ل.س.\u200F"),
  SZL("Swazi Lilangeni", "SZL"),
  THB("Thai Baht", "฿"),
  TJS("Tajikistani Somoni", "TJS"),
  TMT("Turkmenistani Manat", "TMT"),
  TND("Tunisian Dinar", "د.ت."),
  TOP("Tongan Paʻanga", "T$"),
  TRY("Turkish Lira", "TL"),
  TTD("Trinidad and Tobago Dollar", "$"),
  TWD("New Taiwan Dollar", "$"),
  TZS("Tanzanian Shilling", "TSh"),
  UAH("Ukrainian Hryvnia", "₴"),
  UGX("Ugandan Shilling", "USh"),
  USD("US Dollar", "$", false),
  UYU("Uruguayan Peso", "$"),
  UZS("Uzbekistan Som", "UZS"),
  VEF("Venezuelan Bolívar", "Bs.F."),
  VND("Vietnamese Dong", "₫"),
  VUV("Vanuatu Vatu", "VUV"),
  WST("Samoan Tala", "WST"),
  XAF("CFA Franc BEAC", "FCFA"),
  XAG("Silver", "XAG", false),
  XAU("Gold", "XAU", false),
  XCD("East Caribbean Dollar", "XCD"),
  XDR("Special Drawing Rights", "XDR", false),
  XOF("CFA Franc BCEAO", "CFA"),
  XPF("CFP Franc", "XPF"),
  YER("Yemeni Rial", "ر.ي."),
  ZAR("South African Rand", "R"),
  ZMK("Zambian Kwacha", "ZK"),
  ZMW("ZMW", "ZMW"),
  ZWD("Zimbabwean Dollar (1980-2008)", "ZWD"),
  ZWL("Zimbabwean Dollar (2009)", "ZWL");

  private final boolean operable;
  private String name;
  private String symbol;

  CurrencyCode(final String name, final String symbol) {
    this(name, symbol, true);
  }

  CurrencyCode(final String name, final String symbol, final boolean operable) {
    this.name = name;
    this.symbol = symbol;
    this.operable = operable;
  }

  public static CurrencyCode valueOf(final Currency currency) {
    return CurrencyCode.valueOf(currency.getCurrencyCode());
  }

  /**
   * @return The java currency mapping to this value
   */
  public Currency getCurrency() {
    return Currency.getInstance(name());
  }

  /**
   * @return if we can operate in this currency or not
   */
  public boolean isOperable() {
    return operable;
  }
}
