// @see https://github.com/primefaces/primefaces/wiki/Locales --> to add more i18n

// Components like calendar, schedule and features such as client side validation use PrimeFaces Locales Javascript API to display localized values. Add the locales you support in a javascript file and reference it in your page. 
// PrimeFaces only provides English translations by default, if you'd like to share translations, please contribute to this wiki.

// American English
PrimeFaces.locales ['en_US'] = {
    closeText: 'Close',
    prevText: 'Previous',
    nextText: 'Next',
    monthNames: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December' ],
    monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ],
    dayNames: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
    dayNamesShort: ['Sun', 'Mon', 'Tue', 'Wed', 'Tue', 'Fri', 'Sat'],
    dayNamesMin: ['S', 'M', 'T', 'W ', 'T', 'F ', 'S'],
    weekHeader: 'Week',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Only Time',
    timeText: 'Time',
    hourText: 'Time',
    minuteText: 'Minute',
    secondText: 'Second',
    currentText: 'Current Date',
    ampm: false,
    month: 'Month',
    week: 'week',
    day: 'Day',
    allDayText: 'All Day',
    aria: {
        'paginator.PAGE': 'Page {0}',
        'calendar.BUTTON': 'Show Calendar',
        'datatable.sort.ASC': 'activate to sort column ascending',
        'datatable.sort.DESC': 'activate to sort column descending',
        'columntoggler.CLOSE': 'Close'
    },
    messages: {  //optional for Client Side Validation
        'javax.faces.component.UIInput.REQUIRED': '{0}: Validation Error: Value is required.',
        'javax.faces.converter.IntegerConverter.INTEGER': '{2}: \'{0}\' must be a number consisting of one or more digits.',
        'javax.faces.converter.IntegerConverter.INTEGER_detail': '{2}: \'{0}\' must be a number between -2147483648 and 2147483647 Example: {1}',
        'javax.faces.converter.DoubleConverter.DOUBLE': '{2}: \'{0}\' must be a number consisting of one or more digits.',
        'javax.faces.converter.DoubleConverter.DOUBLE_detail': '{2}: \'{0}\' must be a number between 4.9E-324 and 1.7976931348623157E308  Example: {1}',
        'javax.faces.converter.BigDecimalConverter.DECIMAL': '{2}: \'{0}\' must be a signed decimal number.',
        'javax.faces.converter.BigDecimalConverter.DECIMAL_detail': '{2}: \'{0}\' must be a signed decimal number consisting of zero or more digits, that may be followed by a decimal point and fraction.  Example: {1}',
        'javax.faces.converter.BigIntegerConverter.BIGINTEGER': '{2}: \'{0}\' must be a number consisting of one or more digits.',
        'javax.faces.converter.BigIntegerConverter.BIGINTEGER_detail': '{2}: \'{0}\' must be a number consisting of one or more digits. Example: {1}',
        'javax.faces.converter.ByteConverter.BYTE': '{2}: \'{0}\' must be a number between 0 and 255.',
        'javax.faces.converter.ByteConverter.BYTE_detail': '{2}: \'{0}\' must be a number between 0 and 255.  Example: {1}',
        'javax.faces.converter.CharacterConverter.CHARACTER': '{1}: \'{0}\' must be a valid character.',
        'javax.faces.converter.CharacterConverter.CHARACTER_detail': '{1}: \'{0}\' must be a valid ASCII character.',
        'javax.faces.converter.ShortConverter.SHORT': '{2}: \'{0}\' must be a number consisting of one or more digits.',
        'javax.faces.converter.ShortConverter.SHORT_detail': '{2}: \'{0}\' must be a number between -32768 and 32767 Example: {1}',
        'javax.faces.converter.BooleanConverter.BOOLEAN': '{1}: \'{0}\' must be \'true\' or \'false\'',
        'javax.faces.converter.BooleanConverter.BOOLEAN_detail': '{1}: \'{0}\' must be \'true\' or \'false\'.  Any value other than \'true\' will evaluate to \'false\'.',
        'javax.faces.validator.LongRangeValidator.MAXIMUM': '{1}: Validation Error: Value is greater than allowable maximum of \'{0}\'',
        'javax.faces.validator.LongRangeValidator.MINIMUM': '{1}: Validation Error: Value is less than allowable minimum of \'{0}\'',
        'javax.faces.validator.LongRangeValidator.NOT_IN_RANGE': '{2}: Validation Error: Specified attribute is not between the expected values of {0} and {1}.',
        'javax.faces.validator.LongRangeValidator.TYPE={0}': 'Validation Error: Value is not of the correct type.',
        'javax.faces.validator.DoubleRangeValidator.MAXIMUM': '{1}: Validation Error: Value is greater than allowable maximum of \'{0}\'',
        'javax.faces.validator.DoubleRangeValidator.MINIMUM': '{1}: Validation Error: Value is less than allowable minimum of \'{0}\'',
        'javax.faces.validator.DoubleRangeValidator.NOT_IN_RANGE': '{2}: Validation Error: Specified attribute is not between the expected values of {0} and {1}',
        'javax.faces.validator.DoubleRangeValidator.TYPE={0}': 'Validation Error: Value is not of the correct type',
        'javax.faces.converter.FloatConverter.FLOAT': '{2}: \'{0}\' must be a number consisting of one or more digits.',
        'javax.faces.converter.FloatConverter.FLOAT_detail': '{2}: \'{0}\' must be a number between 1.4E-45 and 3.4028235E38  Example: {1}',
        'javax.faces.converter.DateTimeConverter.DATE': '{2}: \'{0}\' could not be understood as a date.',
        'javax.faces.converter.DateTimeConverter.DATE_detail': '{2}: \'{0}\' could not be understood as a date. Example: {1}',
        'javax.faces.converter.DateTimeConverter.TIME': '{2}: \'{0}\' could not be understood as a time.',
        'javax.faces.converter.DateTimeConverter.TIME_detail': '{2}: \'{0}\' could not be understood as a time. Example: {1}',
        'javax.faces.converter.DateTimeConverter.DATETIME': '{2}: \'{0}\' could not be understood as a date and time.',
        'javax.faces.converter.DateTimeConverter.DATETIME_detail': '{2}: \'{0}\' could not be understood as a date and time. Example: {1}',
        'javax.faces.converter.DateTimeConverter.PATTERN_TYPE': '{1}: A \'pattern\' or \'type\' attribute must be specified to convert the value \'{0}\'', 
        'javax.faces.converter.NumberConverter.CURRENCY': '{2}: \'{0}\' could not be understood as a currency value.',
        'javax.faces.converter.NumberConverter.CURRENCY_detail': '{2}: \'{0}\' could not be understood as a currency value. Example: {1}',
        'javax.faces.converter.NumberConverter.PERCENT': '{2}: \'{0}\' could not be understood as a percentage.',
        'javax.faces.converter.NumberConverter.PERCENT_detail': '{2}: \'{0}\' could not be understood as a percentage. Example: {1}',
        'javax.faces.converter.NumberConverter.NUMBER': '{2}: \'{0}\' could not be understood as a date.',
        'javax.faces.converter.NumberConverter.NUMBER_detail': '{2}: \'{0}\' is not a number. Example: {1}',
        'javax.faces.converter.NumberConverter.PATTERN': '{2}: \'{0}\' is not a number pattern.',
        'javax.faces.converter.NumberConverter.PATTERN_detail': '{2}: \'{0}\' is not a number pattern. Example: {1}',
        'javax.faces.validator.LengthValidator.MINIMUM': '{1}: Validation Error: Length is less than allowable minimum of \'{0}\'',
        'javax.faces.validator.LengthValidator.MAXIMUM': '{1}: Validation Error: Length is greater than allowable maximum of \'{0}\'',
        'javax.faces.validator.RegexValidator.PATTERN_NOT_SET': 'Regex pattern must be set.',
        'javax.faces.validator.RegexValidator.PATTERN_NOT_SET_detail': 'Regex pattern must be set to non-empty value.',
        'javax.faces.validator.RegexValidator.NOT_MATCHED': 'Regex Pattern not matched',
        'javax.faces.validator.RegexValidator.NOT_MATCHED_detail': 'Regex pattern of \'{0}\' not matched',
        'javax.faces.validator.RegexValidator.MATCH_EXCEPTION': 'Error in regular expression.',
        'javax.faces.validator.RegexValidator.MATCH_EXCEPTION_detail': 'Error in regular expression, \'{0}\'',
        //optional for bean validation integration in client side validation
        'javax.faces.validator.BeanValidator.MESSAGE': '{0}',
        'javax.validation.constraints.AssertFalse.message': 'must be false',
        'javax.validation.constraints.AssertTrue.message': 'must be true',
        'javax.validation.constraints.DecimalMax.message': 'must be less than or equal to {0}',
        'javax.validation.constraints.DecimalMin.message': 'must be greater than or equal to {0}',
        'javax.validation.constraints.Digits.message': 'numeric value out of bounds (<{0} digits>.<{1} digits> expected)',
        'javax.validation.constraints.Future.message': 'must be in the future',
        'javax.validation.constraints.Max.message': 'must be less than or equal to {0}',
        'javax.validation.constraints.Min.message': 'must be greater than or equal to {0}',
        'javax.validation.constraints.NotNull.message': 'may not be null',
        'javax.validation.constraints.Null.message': 'must be null',
        'javax.validation.constraints.Past.message': 'must be in the past',
        'javax.validation.constraints.Pattern.message': 'must match "{0}"',
        'javax.validation.constraints.Size.message': 'size must be between {0} and {1}'
    }
};

// English
PrimeFaces.locales ['en'] = PrimeFaces.locales ['en_US'];

// Arabic
PrimeFaces.locales ['ar'] = {
    closeText: 'إغلق',
    prevText: 'إلى الخلف',
    nextText: 'إلى الأمام',
    currentText: 'بداية',
    monthNames: ['ديسمبر', 'نوفمبر', 'أكتوبر', 'سبتمبر', 'أغسطس', 'يوليو', 'يونيو', 'مايو', 'ابريل', 'مارس', 'فبراير', 'يناير' ],
    monthNamesShort: ['ديسمبر', 'نوفمبر', 'أكتوبر', 'سبتمبر', 'أغسطس', 'يوليو', 'يونيو', 'مايو', 'ابريل', 'مارس', 'فبراير', 'يناير' ],
    dayNames: ['يوم الأحد‎', 'يوم الإثنين‎', 'يوم الثلاثاء‎', '‏يوم الأَرْبعاء‎', '‏يوم الخَمِيس‎', 'يوم الجُمْعَة‎‎', 'يوم السَّبْت'],
    dayNamesShort: ['الأحد‎', 'الإثنين‎', 'الثلاثاء‎', 'الأَرْبعاء‎', 'الخَمِيس‎', 'الجُمْعَة‎‎', 'السَّبْت'],
    dayNamesMin: ['الأحد‎', 'الإثنين‎', 'الثلاثاء‎', 'الأَرْبعاء‎', 'الخَمِيس‎', 'الجُمْعَة‎‎', 'السَّبْت'],
    weekHeader: 'الأسبوع',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'' ,
    timeOnlyTitle: 'الوقت فقط' ,
    timeText: 'الوقت' ,
    hourText: 'ساعة',
    minuteText: 'دقيقة',
    secondText: 'ثانية',
    ampm: false,
    month: 'الشهر',
    week: 'الأسبوع',
    day: 'اليوم',
    allDayText: 'سا ئراليوم'
};

// Brazilian Portuguese
PrimeFaces.locales['pt-br'] = {
    closeText: 'Fechar',
    prevText: 'Anterior',
    nextText: 'Próximo',
    currentText: 'Começo',
    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],
    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],
    dayNamesMin: ['D','S','T','Q','Q','S','S'],
    weekHeader: 'Semana',
    firstDay: 0,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Só Horas',
    timeText: 'Tempo',
    hourText: 'Hora',
    minuteText: 'Minuto',
    secondText: 'Segundo',
    ampm: false,
    month: 'Mês',
    week: 'Semana',
    day: 'Dia',
    allDayText : 'Todo o Dia'
};

// Catalan
PrimeFaces.locales['ca'] = {
    closeText: 'Tancar',
    prevText: 'Anterior',
    nextText: 'Següent',
    monthNames: ['Gener','Febrer', 'Març', 'Abril', 'Maig', 'Juny', 'Juliol', 'Agost', 'Setembre', 'Octubre', 'Novembre', 'Desembre'],
    monthNamesShort: ['Gen', 'Feb', 'Mar', 'Abr', 'Mai', 'Jun','Jul','Ago','Set','Oct','Nov','Des'],
    dayNames: ['Diumenge','Dilluns','Dimarts','Dimecres','Dijous','Divendres','Dissabte'],
    dayNamesShort: ['Dmg','Dl', 'Dmt', 'Dmc', 'Dj', 'Dv', 'Ds'],
    dayNamesMin: ['Dg','Dl','Dt','Dc','Dj','Dv','Ds'],
    weekHeader: 'Setmana',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Només hora',
    timeText: 'Temps',
    hourText: 'Hora',
    minuteText: 'Minut',
    secondText: 'Segon',
    currentText: 'Data actual',
    ampm: false,
    month: 'Mes',
    week: 'Setmana',
    day: 'Dia',
    allDayText : 'Tot el dia'
};

// Czech
PrimeFaces.locales ['cs_CZ'] = {
    closeText: 'Zavřít',
    prevText: 'Předchozí',
    nextText: 'Následující',
    monthNames: ['Leden', 'Únor', 'Březen', 'Duben', 'Květen', 'Červen', 'Červenec', 'Srpen', 'Září', 'Říjen', 'Listopad', 'Prosinec'],
    monthNamesShort: ['Led', 'Úno', 'Bře', 'Dub', 'Kvě', 'Čer', 'Čvc', 'Srp', 'Zář', 'Říj', 'Lis', 'Pro'],
    dayNames: ['Neděle', 'Pondělí', 'Úterý', 'Středa', 'Čtvrtek', 'Pátek', 'Sobota'],
    dayNamesShort: ['Ne', 'Po', 'Út', 'St', 'Čt', 'Pá', 'So'],
    dayNamesMin: ['Ne', 'Po', 'Út', 'St', 'Čt', 'Pá', 'So'],
    weekHeader: 'Týden',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Pouze čas',
    timeText: 'Čas',
    hourText: 'Hodina',
    minuteText: 'Minuta',
    secondText: 'Sekunda',
    currentText: 'Nyní',
    ampm: false,
    month: 'Měsíc',
    week: 'Týden',
    day: 'Den',
    allDayText: 'Celý den'
};

// Dutch
PrimeFaces.locales['nl'] = {
    closeText: 'Sluiten',
    prevText: 'Terug',
    nextText: 'Volgende',
    currentText: 'Huidig',
    monthNames: ['Januari', 'Februari', 'Maart', 'April', 'Mei', 'Juni', 'Juli', 'Augustus', 'September', 'Oktober', 'November', 'December' ],
    monthNamesShort: ['jan', 'feb', 'mrt', 'apr', 'mei', 'jun', 'jul', 'aug', 'sep', 'okt', 'nov', 'dec' ],
    dayNames: ['Zondag', 'Maandag', 'Dinsdag', 'Woensdag', 'Donderdag', 'Vrijdag', 'Zaterdag'],
    dayNamesShort: ['zo', 'ma', 'di', 'woe', 'do', 'vr', 'za'],
    dayNamesMin: ['Zo', 'Ma', 'Di', 'Wo ', 'Do', 'Vr ', 'Za'],
    weekHeader: 'Week',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Alleen tijd',
    timeText: 'Tijd',
    hourText: 'Uur',
    minuteText: 'Minuut',
    secondText: 'Seconde',
    ampm: false,
    month: 'Maand',
    week: 'week',
    day: 'Dag',
    allDayText: 'Alle Dagen'
};

// French
PrimeFaces.locales ['fr'] = {
   closeText: "Fermer",
   prevText: "Précédent",
   nextText: "Suivant",
   monthNames: ["Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" ],
   monthNamesShort: ["Jan", "Fév", "Mar", "Avr", "Mai", "Jun", "Jul", "Aoû", "Sep", "Oct", "Nov", "Déc" ],
   dayNames: ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"],
   dayNamesShort: ["Dim", "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam"],
   dayNamesMin: ["D", "L", "M", "M", "J", "V", "S"],
   weekHeader: "Semaine",
   firstDay: 1,
   isRTL: false,
   showMonthAfterYear: false,
   yearSuffix:"",
   timeOnlyTitle: "Choisir l'heure",
   timeText: "Heure",
   hourText: "Heures",
   minuteText: "Minutes",
   secondText: "Secondes",
   currentText: "Maintenant",
   ampm: false,
   month: "Mois",
   week: "Semaine",
   day: "Jour",
   allDayText: "Toute la journée",
   messages: {
      // components
      "javax.faces.component.UIInput.CONVERSION" : "{0} : une erreur de conversion s'est produite."
      , "javax.faces.component.UIInput.REQUIRED" : "{0} : Erreur de validation : la valeur est requise."
      , "javax.faces.component.UIInput.UPDATE" : "{0} : Une erreur s'est produite lors du traitement des informations que vous avez entr\u00e9es."
      , "javax.faces.component.UISelectOne.INVALID" : "{0} : Erreur de validation : la valeur n'est pas valide."
      , "javax.faces.component.UISelectMany.INVALID" : "{0} : Erreur de validation : la valeur n'est pas valide."
      // converters
      , "javax.faces.converter.BigDecimalConverter.DECIMAL" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal sign\u00e9."
      , "javax.faces.converter.BigDecimalConverter.DECIMAL_detail" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal sign\u00e9 compos\u00e9 de z\u00e9ro ou plusieurs chiffres, lesquels peuvent \u00eatre suivis d'une d\u00e9cimale et d'une fraction.  Exemple : {1}"
      , "javax.faces.converter.BigIntegerConverter.BIGINTEGER" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal compos\u00e9 d'un ou plusieurs chiffres."
      , "javax.faces.converter.BigIntegerConverter.BIGINTEGER_detail" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal compos\u00e9 d'un ou plusieurs chiffres. Exemple : {1}"
      , "javax.faces.converter.BooleanConverter.BOOLEAN" : "{1} : '{0}' doit \u00eatre 'true' ou 'false'."
      , "javax.faces.converter.BooleanConverter.BOOLEAN_detail" : "{1} : '{0}' doit \u00eatre 'true' ou 'false'.  Toute valeur autre que 'true' sera \u00e9valu\u00e9e comme 'false'."
      , "javax.faces.converter.ByteConverter.BYTE" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal compris entre 0 et 255."
      , "javax.faces.converter.ByteConverter.BYTE_detail" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal compris entre 0 et 255.  Exemple : {1}"
      , "javax.faces.converter.CharacterConverter.CHARACTER" : "{1} : '{0}' doit \u00eatre un caract\u00e8re valide."
      , "javax.faces.converter.CharacterConverter.CHARACTER_detail" : "{1} : '{0}' doit \u00eatre un caract\u00e8re ASCII valide."
      , "javax.faces.converter.DateTimeConverter.DATE" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme une date."
      , "javax.faces.converter.DateTimeConverter.DATE_detail" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme une date. Exemple : {1}"
      , "javax.faces.converter.DateTimeConverter.TIME" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme une heure."
      , "javax.faces.converter.DateTimeConverter.TIME_detail" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme une heure. Exemple : {1}"
      , "javax.faces.converter.DateTimeConverter.DATETIME" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme une date et une heure."
      , "javax.faces.converter.DateTimeConverter.DATETIME_detail" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme une date et une heure. Exemple : {1}"
      , "javax.faces.converter.DateTimeConverter.PATTERN_TYPE" : "{1} : Un attribut 'pattern' ou 'type' doit \u00eatre sp\u00e9cifi\u00e9 pour la conversion de la valeur '{0}'."
      , "javax.faces.converter.DoubleConverter.DOUBLE" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal compos\u00e9 d'un ou plusieurs chiffres."
      , "javax.faces.converter.DoubleConverter.DOUBLE_detail" : "{2} : '{0}' doit \u00eatre un nombre compris entre 4,9E-324 et 1,7976931348623157E308. Exemple : {1}"
      , "javax.faces.converter.EnumConverter.ENUM" : "{2} : '{0}' doit \u00eatre convertible en \u00e9num\u00e9ration."
      , "javax.faces.converter.EnumConverter.ENUM_detail" : "{2} : '{0}' doit \u00eatre convertible en \u00e9num\u00e9ration \u00e0 partir de l'\u00e9num\u00e9ration qui contient la constante '{1}'."
      , "javax.faces.converter.EnumConverter.ENUM_NO_CLASS" : "{1} : '{0}' doit \u00eatre convertible en \u00e9num\u00e9ration \u00e0 partir de l'\u00e9num\u00e9ration, mais aucune classe d'\u00e9num\u00e9ration n'a \u00e9t\u00e9 fournie."
      , "javax.faces.converter.EnumConverter.ENUM_NO_CLASS_detail" : "{1} : '{0}' doit \u00eatre convertible en \u00e9num\u00e9ration \u00e0 partir de l'\u00e9num\u00e9ration, mais aucune classe d'\u00e9num\u00e9ration n'a \u00e9t\u00e9 fournie."
      , "javax.faces.converter.FloatConverter.FLOAT" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal compos\u00e9 d'un ou plusieurs chiffres."
      , "javax.faces.converter.FloatConverter.FLOAT_detail" : "{2} : '{0}' doit \u00eatre un nombre compris entre 1,4E-45 et 3,4028235E38. Exemple : {1}"
      , "javax.faces.converter.IntegerConverter.INTEGER" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal compos\u00e9 d'un ou plusieurs chiffres."
      , "javax.faces.converter.IntegerConverter.INTEGER_detail" : "{2} : '{0}' doit \u00eatre un nombre compris entre -2147483648 et 2147483647. Exemple : {1}"
      , "javax.faces.converter.LongConverter.LONG" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal compos\u00e9 d'un ou plusieurs chiffres."
      , "javax.faces.converter.LongConverter.LONG_detail" : "{2} : '{0}' doit \u00eatre un nombre compris entre -9223372036854775808 et 9223372036854775807. Exemple : {1}"
      , "javax.faces.converter.NumberConverter.CURRENCY" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme une devise."
      , "javax.faces.converter.NumberConverter.CURRENCY_detail" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme une devise. Exemple : {1}"
      , "javax.faces.converter.NumberConverter.PERCENT" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme un pourcentage."
      , "javax.faces.converter.NumberConverter.PERCENT_detail" : "{2} : '{0}' n'a pu \u00eatre interpr\u00e9t\u00e9 comme un pourcentage. Exemple : {1}"
      , "javax.faces.converter.NumberConverter.NUMBER" : "{2}: '{0}' n'est pas un nombre."
      , "javax.faces.converter.NumberConverter.NUMBER_detail" : "{2}: '{0}' n'est pas un nombre. Exemple : {1}"
      , "javax.faces.converter.NumberConverter.PATTERN" : "{2}: '{0}' n'est pas un mod\u00e8le de nombre."
      , "javax.faces.converter.NumberConverter.PATTERN_detail" : "{2}: '{0}' n'est pas un mod\u00e8le de nombre. Exemple : {1}"
      , "javax.faces.converter.ShortConverter.SHORT" : "{2} : '{0}' doit \u00eatre un nombre d\u00e9cimal compos\u00e9 d'un ou plusieurs chiffres."
      , "javax.faces.converter.ShortConverter.SHORT_detail" : "{2} : '{0}' doit \u00eatre un nombre compris entre -32768 et 32767. Exemple : {1}"
      , "javax.faces.converter.STRING" : "{1} : Impossible de convertir '{0}' en cha\u00eene."
      // validators
      , "javax.faces.validator.NOT_IN_RANGE" : "Erreur de validation : l'attribut sp\u00e9cifi\u00e9 n'est pas compris entre les valeurs attendues de {0} et de {1}."
      , "javax.faces.validator.DoubleRangeValidator.MAXIMUM" : "{1} : Erreur de validation : la valeur est sup\u00e9rieure au maximum autoris\u00e9 de '{0}'"
      , "javax.faces.validator.DoubleRangeValidator.MINIMUM" : "{1} : Erreur de validation : la valeur est inf\u00e9rieure au minimum autoris\u00e9 de '{0}'"
      , "javax.faces.validator.DoubleRangeValidator.NOT_IN_RANGE" : "{2} : Erreur de validation : l'attribut sp\u00e9cifi\u00e9 n'est pas compris entre les valeurs attendues de {0} et de {1}."
      , "javax.faces.validator.DoubleRangeValidator.TYPE" : "{0} : Erreur de validation : la valeur n'est pas du bon type."
      , "javax.faces.validator.LengthValidator.MAXIMUM" : "{1} : Erreur de validation : la valeur est sup\u00e9rieure au maximum autoris\u00e9 de '{0}'"
      , "javax.faces.validator.LengthValidator.MINIMUM" : "{1} : Erreur de validation : la valeur est inf\u00e9rieure au minimum autoris\u00e9 de '{0}'"
      , "javax.faces.validator.LongRangeValidator.MAXIMUM" : "{1} : Erreur de validation : la valeur est sup\u00e9rieure au maximum autoris\u00e9 de '{0}'"
      , "javax.faces.validator.LongRangeValidator.MINIMUM" : "{1} : Erreur de validation : la valeur est inf\u00e9rieure au minimum autoris\u00e9 de '{0}'"
      , "javax.faces.validator.LongRangeValidator.NOT_IN_RANGE" : "{2} : Erreur de validation : l'attribut sp\u00e9cifi\u00e9 n'est pas compris entre les valeurs attendues de {0} et de {1}."
      , "javax.faces.validator.LongRangeValidator.TYPE" : "{0} : Erreur de validation : la valeur n'est pas du bon type."
      , "javax.faces.validator.RegexValidator.NOT_MATCHED" : "{1} : Erreur de validation : la valeur ne correspond pas au mod\u00e8le '{0}'"
      , "javax.faces.validator.BeanValidator.MESSAGE" : "{1} : {0}"
   }
};

// German
PrimeFaces.locales ['de'] = {
    closeText: 'Schließen',
    prevText: 'Zurück',
    nextText: 'Weiter',
    monthNames: ['Januar', 'Februar', 'März', 'April', 'Mai', 'Juni', 'Juli', 'August', 'September', 'Oktober', 'November', 'Dezember' ],
    monthNamesShort: ['Jan', 'Feb', 'Mär', 'Apr', 'Mai', 'Jun', 'Jul', 'Aug', 'Sep', 'Okt', 'Nov', 'Dez' ],
    dayNames: ['Sonntag', 'Montag', 'Dienstag', 'Mittwoch', 'Donnerstag', 'Freitag', 'Samstag'],
    dayNamesShort: ['Son', 'Mon', 'Die', 'Mit', 'Don', 'Fre', 'Sam'],
    dayNamesMin: ['S', 'M', 'D', 'M ', 'D', 'F ', 'S'],
    weekHeader: 'Woche',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Nur Zeit',
    timeText: 'Zeit',
    hourText: 'Stunde',
    minuteText: 'Minute',
    secondText: 'Sekunde',
    currentText: 'Aktuelles Datum',
    ampm: false,
    month: 'Monat',
    week: 'Woche',
    day: 'Tag',
    allDayText: 'Ganzer Tag'
};

// Greek
PrimeFaces.locales['el'] = {
    closeText: 'Κλείσιμο',
    prevText: 'Προηγούμενο',
    nextText: 'Επόμενο',
    monthNames: ['Ιανουάριος', 'Φεβρουάριος', 'Μάρτιος', 'Απρίλιος', 'Μάϊος', 'Ιούνιος', 'Ιούλιος', 'Άυγουστος', 'Σεπτέμβιος', 'Οκτώβριος', 'Νοέμβριος', 'Δεκέμβριος'],
    monthNamesShort: ['Ιαν', 'Φεβ', 'Μαρ', 'Απρ', 'Μαι', 'Ιουν', 'Ιουλ', 'Αυγ', 'Σεπ', 'Οκτ', 'Νοε', 'Δεκ'],
    dayNames: ['Κυριακή', 'Δευτέρα', 'Τρίτη', 'Τετάρτη', 'Πέμπτη', 'Παρασκευή', 'Σάββατο'],
    dayNamesShort: ['Κυρ', 'Δευ', 'Τρι', 'Τετ', 'Πεμ', 'Παρ', 'Σαβ'],
    dayNamesMin: ['Κ', 'Δ', 'Τρ', 'Τε', 'Πε', 'Πα', 'Σ'],
    weekHeader: 'Εβδ',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Επιλογή Ώρας',
    timeText: 'Χρόνος',
    hourText: 'Ώρα',
    minuteText: 'Λεπτό',
    secondText: 'Δευτερόλεπτο',
    currentText: 'Σημερινή Ημερομηνία',
    ampm: false,
    month: 'Μήνας',
    week: 'Εβδομάδα',
    day: 'Ημέρα',
    allDayText: 'Όλη Μέρα',
    messages: {
        'javax.faces.component.UIInput.CONVERSION': '{0}: Παρουσιάστηκε σφάλμα μετατροπής.',
        'javax.faces.component.UIInput.REQUIRED': '{0}: Σφάλμα επικύρωσης. Η τιμή είναι απαραίτητη.',
        'javax.faces.component.UIInput.UPDATE': '{0}: Παρουσιάστηκε ένα σφάλμα κατά την επεξεργασία των πληροφοριών που υποβάλατε. ',
        'javax.faces.component.UISelectOne.INVALID': '{0}: Σφάλμα επικύρωσης. Η τιμή δεν είναι έγκυρη',
        'javax.faces.component.UISelectMany.INVALID': '{0}: Σφάλμα επικύρωσης. Η τιμή δεν είναι έγκυρη',
        'javax.faces.converter.BigDecimalConverter.DECIMAL': '{2}: \'\'{0}\'\' πρέπει να είναι ένας προσημασμένος δεκαδικός αριθμός.',
        'javax.faces.converter.BigDecimalConverter.DECIMAL_detail': '{2}: \'\'{0}\'\' πρέπει να είναι ένας προσημασμένος δεκαδικός αριθμός αποτελούμενος απο μηδέν ή περισσότερα ψηφία, τα οποία μπορεί να ακολουθούνται από ένα δεκαδικό σημείο και μέρος.  Παράδειγμα: {1} ',
        'javax.faces.converter.BigIntegerConverter.BIGINTEGER': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός αποτελούμενος απο ένα ή περισσότερα ψηφία.',
        'javax.faces.converter.BigIntegerConverter.BIGINTEGER_detail': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός αποτελούμενος απο ένα ή περισσότερα ψηφία. Παράδειγμα: {1} ',
        'javax.faces.converter.BooleanConverter.BOOLEAN': '{1}: \'\'{0}\'\' πρέπει να είναι \'true\' ή \'false\'.',
        'javax.faces.converter.BooleanConverter.BOOLEAN_detail': '{1}: \'\'{0}\'\' πρέπει να είναι \'true\' ή \'false\'.  Οποιαδήποτε τιμή εκτός από \'true\' θα εκτιμηθεί σε \'false\'.',
        'javax.faces.converter.ByteConverter.BYTE': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός μεταξύ -128 και 127.',
        'javax.faces.converter.ByteConverter.BYTE_detail': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός μεταξύ -128 και 127.  Παράδειγμα: {1} ',
        'javax.faces.converter.CharacterConverter.CHARACTER': '{1}: \'\'{0}\'\' πρέπει να είναι ένας έγκυρος χαρακτήρας.',
        'javax.faces.converter.CharacterConverter.CHARACTER_detail': '{1}: \'\'{0}\'\' πρέπει να είναι ένας έγκυρος ASCII χαρακτήρας.',
        'javax.faces.converter.DateTimeConverter.DATE': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν ημερομηνία.',
        'javax.faces.converter.DateTimeConverter.DATE_detail': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν ημερομηνία. Παράδειγμα: {1} ',
        'javax.faces.converter.DateTimeConverter.TIME': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν ώρα.',
        'javax.faces.converter.DateTimeConverter.TIME_detail': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν ώρα. Παράδειγμα: {1} ',
        'javax.faces.converter.DateTimeConverter.DATETIME': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν ημερομηνία και ώρα.',
        'javax.faces.converter.DateTimeConverter.DATETIME_detail': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν ημερομηνία και ώρα. Παράδειγμα: {1} ',
        'javax.faces.converter.DateTimeConverter.PATTERN_TYPE': '{1}: Πρέπει να έχει οριστεί το χαρακτηριστικό \'pattern\' ή \'type\' για να μετατραπεί η τιμή \'\'{0}\'\'.',
        'javax.faces.converter.DoubleConverter.DOUBLE': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός αποτελούμενος από ένα ή περισσότερα ψηφία.',
        'javax.faces.converter.DoubleConverter.DOUBLE_detail': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός μεταξύ 4.9E-324 και 1.7976931348623157E308  Παράδειγμα: {1} ',
        'javax.faces.converter.EnumConverter.ENUM': '{2}: \'\'{0}\'\' πρέπει να είναι μετατρέψιμο σε μία enum',
        'javax.faces.converter.EnumConverter.ENUM_detail': '{2}: \'\'{0}\'\' πρέπει να είναι μετατρέψιμο σε μία enum από την enum που περιλαμβάνει την σταθερά \'\'{1}\'\'.',
        'javax.faces.converter.EnumConverter.ENUM_NO_CLASS': '{1}: \'\'{0}\'\' πρέπει να είναι μετατρέψιμο σε μία enum από την enum, αλλα καμία enum κλάση δεν παρέχεται.',
        'javax.faces.converter.EnumConverter.ENUM_NO_CLASS_detail': '{1}: \'\'{0}\'\' πρέπει να είναι μετατρέψιμο σε μία enum από την enum, αλλα καμία enum κλάση δεν παρέχεται.',
        'javax.faces.converter.FloatConverter.FLOAT': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός αποτελούμενος από ένα ή περισσότερα ψηφία.',
        'javax.faces.converter.FloatConverter.FLOAT_detail': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός μεταξύ 1.4E-45 και 3.4028235E38  Παράδειγμα: {1}',
        'javax.faces.converter.IntegerConverter.INTEGER': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός αποτελούμενος από ένα ή περισσότερα ψηφία.',
        'javax.faces.converter.IntegerConverter.INTEGER_detail': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός μεταξύ -2147483648 και 2147483647 Παράδειγμα: {1}',
        'javax.faces.converter.LongConverter.LONG': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός αποτελούμενος από ένα ή περισσότερα ψηφία.',
        'javax.faces.converter.LongConverter.LONG_detail': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός μεταξύ -9223372036854775808 και 9223372036854775807 Παράδειγμα: {1}',
        'javax.faces.converter.NumberConverter.CURRENCY': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν τιμή νομίσματος.',
        'javax.faces.converter.NumberConverter.CURRENCY_detail': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν τιμή νομίσματος. Παράδειγμα: {1}',
        'javax.faces.converter.NumberConverter.PERCENT': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν ποσοστό.',
        'javax.faces.converter.NumberConverter.PERCENT_detail': '{2}: \'\'{0}\'\' δεν μπορεί να ερμηνευτεί σαν ποσοστό. Παράδειγμα: {1}',
        'javax.faces.converter.NumberConverter.NUMBER': '{2}: \'\'{0}\'\' δεν είναι αριθμός.',
        'javax.faces.converter.NumberConverter.NUMBER_detail': '{2}: \'\'{0}\'\' δεν είναι αριθμός. Παράδειγμα: {1}',
        'javax.faces.converter.NumberConverter.PATTERN': '{2}: \'\'{0}\'\' δεν είναι ένα αριθμητικό μοτίβο.',
        'javax.faces.converter.NumberConverter.PATTERN_detail': '{2}: \'\'{0}\'\' δεν είναι ένα αριθμητικό μοτίβο. Παράδειγμα: {1}',
        'javax.faces.converter.ShortConverter.SHORT': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός αποτελούμενος από ένα ή περισσότερα ψηφία.',
        'javax.faces.converter.ShortConverter.SHORT_detail': '{2}: \'\'{0}\'\' πρέπει να είναι ένας αριθμός μεταξύ -32768 και 32767 Παράδειγμα: {1}',
        'javax.faces.converter.STRING': '{1}: Αδυναμία μετατροπής του \'\'{0}\'\' σε αλφαριθμητικό.',
        'javax.faces.validator.DoubleRangeValidator.MAXIMUM': '{1}: Σφάλμα επικύρωσης: Η τιμή είναι μεγαλύτερη από το επιτρεπτό μέγιστο "{0}"',
        'javax.faces.validator.DoubleRangeValidator.MINIMUM': '{1}: Σφάλμα επικύρωσης: Η τιμή είναι μικρότερη από το επιτρεπτό ελάχιστο \'\'{0}\'\'',
        'javax.faces.validator.DoubleRangeValidator.NOT_IN_RANGE': '{2}: Σφάλμα επικύρωσης: Το καθορισμένο χαρακτηριστικό δεν είναι μεταξύ των αναμενόμενων τιμών {0} και {1}.',
        'javax.faces.validator.DoubleRangeValidator.TYPE': '{0}: Σφάλμα επικύρωσης: Η τιμή δεν είναι σωστού τύπου',
        'javax.faces.validator.LengthValidator.MAXIMUM': '{1}: Σφάλμα επικύρωσης: Το μέγεθος είναι μεγαλύτερο από το επιτρεπτό μέγιστο \'\'{0}\'\'',
        'javax.faces.validator.LengthValidator.MINIMUM': '{1}: Σφάλμα επικύρωσης: Το μέγεθος είναι μικρότερο από το επιτρεπτό ελάχιστο \'\'{0}\'\'',
        'javax.faces.validator.LongRangeValidator.MAXIMUM': '{1}: Σφάλμα επικύρωσης: Η τιμή είναι μεγαλύτερη από το επιτρεπτό μέγιστο \'\'{0}\'\'',
        'javax.faces.validator.LongRangeValidator.MINIMUM': '{1}: Σφάλμα επικύρωσης: Η τιμή είναι μικρότερη από το επιτρεπτό ελάχιστο \'\'{0}\'\'',
        'javax.faces.validator.LongRangeValidator.NOT_IN_RANGE': '{2}: Σφάλμα επικύρωσης: Το καθορισμένο χαρακτηριστικό δεν είναι μεταξύ των αναμενόμενων τιμών {0} και {1}.',
        'javax.faces.validator.LongRangeValidator.TYPE': '{0}: Σφάλμα επικύρωσης: Η τιμή δεν είναι σωστού τύπου.',
        'javax.faces.validator.NOT_IN_RANGE': 'Σφάλμα επικύρωσης: Το καθορισμένο χαρακτηριστικό δεν είναι μεταξύ των αναμενόμενων τιμών {0} και {1}.',
        'javax.faces.validator.RegexValidator.PATTERN_NOT_SET': 'Πρέπει να καθορίστεί ένα μοτίβο Κανονικών Εκφράσεων.',
        'javax.faces.validator.RegexValidator.PATTERN_NOT_SET_detail': 'Πρέπει να καθοριστεί ένα μη κενό μοτίβο Κανονικών Εκφράσεων.',
        'javax.faces.validator.RegexValidator.NOT_MATCHED': 'Το μοτίβο Κανονικών Εκφράσεων δεν ταιριάζει',
        'javax.faces.validator.RegexValidator.NOT_MATCHED_detail': 'Το μοτίβο Κανονικών Εκφράσεων \'\'{0}\'\' δεν ταιριάζει',
        'javax.faces.validator.RegexValidator.MATCH_EXCEPTION': 'Σφάλμα στην Κανονική Έκφραση.',
        'javax.faces.validator.RegexValidator.MATCH_EXCEPTION_detail': 'Σφάλμα στην Κανονική Έκφραση, \'\'{0}\'\'',
        'javax.faces.validator.BeanValidator.MESSAGE': '{0}',
        'javax.validation.constraints.AssertFalse.message': 'πρέπει να είναι false',
        'javax.validation.constraints.AssertTrue.message': 'πρέπει να είναι true',
        'javax.validation.constraints.DecimalMax.message': 'πρέπει να είναι μικρότερο ${inclusive == true ? \'ή ίσο\' : \'\'} από {value}',
        'javax.validation.constraints.DecimalMin.message': 'πρέπει να είναι μεγαλύτερο ${inclusive == true ? \'ή ίσο\' : \'\'} από {value}',
        'javax.validation.constraints.Digits.message': 'αριθμιτική τιμή εκτός ορίων (<{integer} ψηφία>.<{fraction} ψηφία> η αναμενόμενη μορφή)',
        'javax.validation.constraints.Future.message': 'πρέπει να είναι στο μέλλον',
        'javax.validation.constraints.Max.message': 'πρέπει να είναι μικρότερο ή ίσο από {value}',
        'javax.validation.constraints.Min.message': 'πρέπει να είναι μεγαλύτερο ή ίσο από {value}',
        'javax.validation.constraints.NotNull.message': 'δεν μπορεί να είναι null',
        'javax.validation.constraints.Null.message': 'πρέπει να είναι null',
        'javax.validation.constraints.Past.message': 'πρέπει να είναι στο παρελθόν',
        'javax.validation.constraints.Pattern.message': 'πρέπει να ταιριάζει "{regexp}"',
        'javax.validation.constraints.Size.message': 'μέγεθος πρέπει να είναι μεταξύ {min} και {max}',
        'org.hibernate.validator.constraints.CreditCardNumber.message': 'μη έγκυρος αριθμός πιστωτικής κάρτας',
        'org.hibernate.validator.constraints.Currency.message': 'μη έγκυρο νόμισμα (πρέπει να είναι ένα από {value})',
        'org.hibernate.validator.constraints.EAN.message': 'μη έγκυρο {type} barcode',
        'org.hibernate.validator.constraints.Email.message': 'η διεύθυνση email δεν έχει σωστή μορφή',
        'org.hibernate.validator.constraints.Length.message': 'μέγεθος πρέπει να είναι μεταξύ {min} και {max}',
        'org.hibernate.validator.constraints.LuhnCheck.message': 'Το ψηφίο ελέγχου ${validatedValue} δεν είναι έγκυρο, το Luhn Modulo 10 άθροισμα ελέγχου απέτυχε',
        'org.hibernate.validator.constraints.Mod10Check.message': 'Το ψηφίο ελέγχου ${validatedValue} δεν είναι έγκυρο, το Modulo 10 άθροισμα ελέγχου απέτυχε',
        'org.hibernate.validator.constraints.Mod11Check.message': 'Το ψηφίο ελέγχου ${validatedValue} δεν είναι έγκυρο, το Modulo 11 άθροισμα ελέγχου απέτυχε',
        'org.hibernate.validator.constraints.ModCheck.message': 'Το ψηφίο ελέγχου ${validatedValue} δεν είναι έγκυρο, το ${modType} άθροισμα ελέγχου απέτυχε',
        'org.hibernate.validator.constraints.NotBlank.message': 'δεν μπορεί να είναι κενό',
        'org.hibernate.validator.constraints.NotEmpty.message': 'δεν μπορεί να είναι κενό',
        'org.hibernate.validator.constraints.ParametersScriptAssert.message': 'η script έκφραση "{script}" δεν εκτιμήθηκε σε true',
        'org.hibernate.validator.constraints.Range.message': 'πρέπει να είναι μεταξύ {min} και {max}',
        'org.hibernate.validator.constraints.SafeHtml.message': 'μπορεί να περιέχει μη ασφαλές html περιεχόμενο',
        'org.hibernate.validator.constraints.ScriptAssert.message': 'η script έκφραση "{script}" δεν εκτιμήθηκε σε true',
        'org.hibernate.validator.constraints.URL.message': 'πρέπει να είναι ένα έγκυρο URL',
        'org.hibernate.validator.constraints.br.CNPJ.message': 'Μη έγκυρος εταιρικός αριθμός μητρώου φορολογουμένου Βραζιλίας (CNPJ)',
        'org.hibernate.validator.constraints.br.CPF.message': 'Μη έγκυρος προσωπικός αριθμός μητρώου φορολογουμένου Βραζιλίας (CPF)',
        'org.hibernate.validator.constraints.br.TituloEleitoral.message': 'Μη έγκυρος Αριθμός Ταυτοποίησης Ψηφοφόρου Βραζιλίας',
        'org.hibernate.validator.constraints.pl.REGON.message': 'Μη έγκυρος Αριθμός Ταυτοποίησης Φορολογουμένου Πολωνίας (REGON)',
        'org.hibernate.validator.constraints.pl.NIP.message': 'Μη έγκυρος Αριθμός Ταυτοποίησης ΦΠΑ (NIP)',
        'org.hibernate.validator.constraints.pl.PESEL.message': 'Μη έγκυρος Εθνικός Αριθμός Ταυτοποίησης Πολωνίας (PESEL)'
    }
};

// Hebrew
PrimeFaces.locales ['he'] = {
    closeText: 'סגור',
    prevText: 'הקודם',
    nextText: 'הבא',
    monthNames: ['ינואר','פברואר','מרץ','אפריל','מאי','יוני',
    'יולי','אוגוסט','ספטמבר','אוקטובר','נובמבר','דצמבר'],
    monthNamesShort: ['1','2','3','4','5','6',
    '7','8','9','10','11','12'],
    dayNames: ['ראשון','שני','שלישי','רביעי','חמישי','שישי','שבת'],
    dayNamesShort: ['א\'','ב\'','ג\'','ד\'','ה\'','ו\'','שבת'],
    dayNamesMin: ['א\'','ב\'','ג\'','ד\'','ה\'','ו\'','שבת'],
    weekHeader: 'שבוע',
    firstDay: 0,
    isRTL: true,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'זמן בלבד',
    timeText: 'זמן',
    hourText: 'שעה',
    minuteText: 'דקה',
    secondText: 'שניה',
    currentText: 'היום',
    ampm: false,
    month: 'חודש',
    week: 'שבוע',
    day: 'יום',
    allDayText: 'כל היום'
};

// Hungarian
PrimeFaces.locales['hu']= {
    closeText: 'Bezárás',
    prevText: 'Előző',
    nextText: 'Következő',
    monthNames: ['Január', 'Február', 'Március', 'Április', 'Május', 'Június', 'Július', 'Augusztus', 'Szeptember', 'Október', 'November', 'December' ],
    monthNamesShort: ['Jan', 'Febr', 'Márc', 'Ápr', 'Máj', 'Jún', 'Júl', 'Aug', 'Szept', 'Okt', 'Nov', 'Dec'],
    dayNames: ['Vasárnap', 'Hétfő', 'Kedd', 'Szerda', 'Csütörtök', 'Péntek', 'Szombat'],
    dayNamesShort: ['Vas', 'H', 'K', 'Sze', 'Csüt', 'P', 'Szo'],
    dayNamesMin: ['V', 'H', 'K', 'Sze ', 'Cs', 'P ', 'Szo'],
    weekHeader: 'Hét',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: true,
    yearSuffix:'.',
    timeOnlyTitle: 'Csak óra',
    timeText: 'Időpont',
    hourText: 'Óra',
    minuteText: 'Perc',
    secondText: 'Másodperc',
    currentText: 'Ma',
    ampm: false,
    month: 'Hónap',
    week: 'Hét',
    day: 'Nap',
    allDayText: 'Egész nap'
};

// Italian
PrimeFaces.locales ['it'] = {
     closeText: 'Chiudi',
     prevText: 'Precedente',
     nextText: 'Prossimo',
     monthNames: ['Gennaio', 'Febbraio', 'Marzo', 'Aprile', 'Maggio', 'Giugno', 'Luglio', 'Agosto', 'Settembre', 'Ottobre', 'Novembre', 'Dicembre' ],
     monthNamesShort: ['Gen', 'Feb', 'Mar', 'Apr', 'Mag', 'Giu', 'Lug', 'Ago', 'Set', 'Ott', 'Nov', 'Dic' ],
     dayNames: ['Domenica', 'Lunedì', 'Martedì', 'Mercoledì', 'Giovedì', 'Venerdì', 'Sabato'],
     dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mer', 'Gio', 'Ven', 'Sab'],
     dayNamesMin: ['D', 'L', 'M', 'M ', 'G', 'V ', 'S'],
     weekHeader: 'Sett',
     firstDay: 1,
     isRTL: false,
     showMonthAfterYear: false,
     yearSuffix:'',
     timeOnlyTitle: 'Solo Tempo',
     timeText: 'Ora',
     hourText: 'Ore',
     minuteText: 'Minuto',
     secondText: 'Secondo',
     currentText: 'Oggi',
     ampm: false,
     month: 'Mese',
     week: 'Settimana',
     day: 'Giorno',
     allDayText: 'Tutto il Giorno'
 };

// Latvian
PrimeFaces.locales['lv'] = {
    closeText: 'Aizvērt',
    prevText: 'Iepriekšējais',
    nextText: 'Nākošais',
    monthNames: ['Janvāris', 'Februāris', 'Marts', 'Aprīlis', 'Maijs', 'Jūnijs', 'Jūlijs', 'Augusts', 'Septembris', 'Oktobris', 'Novembris', 'Decembris' ],
    monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'Mai', 'Jūn', 'Jūl', 'Aug', 'Sep', 'Okt', 'Nov', 'Dec' ],
    dayNames: ['Svētdiena', 'Pirmdiena', 'Otrdiena', 'Trešdiena', 'Ceturtdiena', 'Piektdiena', 'Sestdiena'],
    dayNamesShort: ['Svē', 'Pirm', 'Otr', 'Tre', 'Cet', 'Pie', 'Ses'],
    dayNamesMin: ['Sv', 'P', 'O', 'T ', 'C', 'P ', 'S'],
    weekHeader: 'Nedēļa',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Tikai Laiks',
    timeText: 'Laiks',
    hourText: 'Stunda',
    minuteText: 'Minūte',
    secondText: 'Sekunde',
    currentText: 'Šodiena',
    ampm: false,
    month: 'Mēnesis',
    week: 'nedēļa',
    day: 'Diena',
    allDayText: 'Visa Diena'
};

// Polish
PrimeFaces.locales['pl'] = {
    closeText: 'Zamknij',
    prevText: 'Poprzedni',
    nextText: 'Następny',
    monthNames: ['Styczeń','Luty','Marzec','Kwiecień','Maj','Czerwiec','Lipiec','Sierpień','Wrzesień','Październik','Listopad','Grudzień'],
    monthNamesShort: ['Sty','Lut','Mar','Kwi','Maj','Cze', 'Lip','Sie','Wrz','Paź','Lis','Gru'],
    dayNames: ['Niedziela','Poniedziałek','Wtorek','Środa','Czwartek','Piątek','Sobota'],
    dayNamesShort: ['Nie','Pon','Wt','Śr','Czw','Pt','So'],
    dayNamesMin: ['N','P','W','Ś','Cz','P','S'],
    weekHeader: 'Tydzień',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: 'r',
    timeOnlyTitle: 'Tylko czas',
    timeText: 'Czas',
    hourText: 'Godzina',
    minuteText: 'Minuta',
    secondText: 'Sekunda',
    currentText: 'Teraz',
    ampm: false,
    month: 'Miesiąc',
    week: 'Tydzień',
    day: 'Dzień',
    allDayText : 'Cały dzień'
};

// Portuguese
PrimeFaces.locales['pt-pt'] = {
    closeText: 'Fechar',
    prevText: 'Anterior',
    nextText: 'Próximo',
    currentText: 'Hoje',
    monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],
    dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
    dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'],
    dayNamesMin: ['D','S','T','Q','Q','S','S'],
    weekHeader: 'Semana',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Só Horas',
    timeText: 'Horas',
    hourText: 'Hora',
    minuteText: 'Minuto',
    secondText: 'Segundo',
    ampm: false,
    month: 'Mês',
    week: 'Semana',
    day: 'Dia',
    allDayText : 'Todo Dia'
};

// Romanian
PrimeFaces.locales ['ro'] = {
    closeText: 'Închide',
    prevText: 'Înapoi',
    nextText: 'Înainte',
    currentText: 'Acasă',
    monthNames: ['Ianuarie', 'Februarie', 'Martie', 'Aprilie', 'Mai', 'Iunie', 'Iulie', 'August', 'Septembrie', 'Octombrie', 'Noiembrie', 'Decembrie' ],
    monthNamesShort: ['Ian', 'Feb', 'Mar', 'Apr', 'Mai', 'Iun', 'Iul', 'Aug', 'Sep', 'Oct', 'Noi', 'Dec' ],
    dayNames: ['Duminică', 'Luni', 'Marți', 'Miercuri', 'Joi', 'Vineri', 'Sâmbătă'],
    dayNamesShort: ['Dum', 'Lun', 'Mar', 'Mie', 'Joi', 'Vin', 'Sâm'],
    dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
    weekHeader: 'Săptămâna',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Numai timp',
    timeText: 'Timp',
    hourText: 'Ora',
    minuteText: 'Minut',
    secondText: 'Secunde',
    ampm: false,
    month: 'Luna',
    week: 'Săptămâna',
    day: 'Zi',
    allDayText: 'Toată ziua'
};

// Russian
PrimeFaces.locales ['ru'] = {
    closeText: 'Закрыть',
    prevText: 'Назад',
    nextText: 'Вперёд',
    monthNames: ['Январь', 'Февраль' , 'Март' , 'Апрель' , 'Май' , 'Июнь' , 'Июль' , 'Август' , 'Сентябрь','Октябрь','Ноябрь','Декабрь' ],
    monthNamesShort: ['Янв', 'Фев', 'Мар', 'Апр', 'Май', 'Июн', 'Июл', 'Авг', 'Сен', 'Окт', 'Ноя', 'Дек' ],
    dayNames: ['Воскресенье', 'Понедельник', 'Вторник', 'Среда', 'Четверг', 'Пятница', 'Субота'],
    dayNamesShort: ['Воск','Пон' , 'Вт' , 'Ср' , 'Четв' , 'Пят' , 'Суб'],
    dayNamesMin: ['В', 'П', 'Вт', 'С ', 'Ч', 'П ', 'Сб'],
    weekHeader: 'Неделя',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Только время',
    timeText: 'Время',
    hourText: 'Час',
    minuteText: 'Минута',
    secondText: 'Секунда',
    currentText: 'Сегодня',
    ampm: false,
    month: 'Месяц',
    week: 'неделя',
    day: 'День',
    allDayText: 'Весь день'
};

// Serbian
PrimeFaces.locales ['sr'] = {
    closeText: 'Zatvori',
    prevText: 'Nazad',
    nextText: 'Napred',
    monthNames: ['Januar', 'Februar', 'Mart', 'April', 'Maj', 'Juni', 'Juli', 'Avgust', 'Septembar', 'Oktobar', 'Novembar', 'Decembar' ],
    monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'Maj', 'Jun', 'Jul', 'Avg', 'Sep', 'Okt', 'Nov', 'Dec' ],
    dayNames: ['Nedelja', 'Ponedeljak', 'Utorak', 'Sreda', 'Četvrtak', 'Petak', 'Subota'],
    dayNamesShort: ['Ned', 'Pon', 'Uto', 'Sre', 'Čet', 'Pet', 'Sub'],
    dayNamesMin: ['N', 'P', 'U', 'S ', 'Č', 'P ', 'S'],
    weekHeader: 'Sedmica',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Samo Vreme',
    timeText: 'Vreme',
    hourText: 'Sat',
    minuteText: 'Minuta',
    secondText: 'Sekunda',
    currentText: 'Danas',
    ampm: false,
    month: 'Mesec',
    week: 'sedmica',
    day: 'Dan',
    allDayText: 'Celi Dan'
};

// Simplified Chinese
PrimeFaces.locales['zh_CN'] = {
    closeText: '关闭',
    prevText: '上个月',
    nextText: '下个月',
    currentText: '今天',
    monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
    monthNamesShort: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
    dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
    dayNamesShort: ['日','一','二','三','四','五','六'],
    dayNamesMin: ['日','一','二','三','四','五','六'],
    weekHeader: '周',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: true,
    yearSuffix: '', // 年
    timeOnlyTitle: '仅时间',
    timeText: '时间',
    hourText: '时',
    minuteText: '分',
    secondText: '秒',
    ampm: false,
    month: '月',
    week: '周',
    day: '日',
    allDayText : '全天'
};

// Slovak
PrimeFaces.locales ['sk'] = {
    closeText: 'Zavrieť',
    prevText: 'Predošlý',
    nextText: 'Nasledujúci',
    monthNames: ['Január', 'Február', 'Marec', 'Apríl', 'Máj', 'Jún', 'Júl', 'August', 'September', 'Október', 'November', 'December'],
    monthNamesShort: ['Jan', 'Feb', 'Mar', 'Apr', 'Máj', 'Jún', 'Júl', 'Aug', 'Sep', 'Okt', 'Nov', 'Dec'],
    dayNames: ['Nedeľa', 'Pondelok', 'Utorok', 'Streda', 'Štvrtok', 'Piatok', 'Sobota'],
    dayNamesShort: ['Ne', 'Po', 'Ut', 'St', 'Št', 'Pi', 'So'],
    dayNamesMin: ['Ne', 'Po', 'Ut', 'St', 'Št', 'Pi', 'So'],
    weekHeader: 'Týždeň',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Len čas',
    timeText: 'Čas',
    hourText: 'Hodina',
    minuteText: 'Minúta',
    secondText: 'Sekunda',
    currentText: 'Teraz',
    ampm: false,
    month: 'Mesiac',
    week: 'Týždeň',
    day: 'Deň',
    allDayText: 'Celý deň'
};

// Slovenian
PrimeFaces.locales ['sl'] = {
    closeText: 'Zapri',
    prevText: 'Nazaj',
    nextText: 'Naprej',
    monthNames : ['Januar', 'Februar', 'Marec', 'April', 'Maj', 'Junij', 'Julij', 'Avgust', 'September', 'Oktober', 'November', 'December'],
    monthNamesShort : ['Jan', 'Feb', 'Mar', 'Apr', 'Maj', 'Jun', 'Jul', 'Avg', 'Sep', 'Okt', 'Nov', 'Dec'],
    dayNames : ['Nedelja', 'Ponedeljek', 'Torek', 'Sreda', '\u010Cetrtek', 'Petek', 'Sobota'],
    dayNamesShort : ['Ned', 'Pon', 'Tor', 'Sre', '\u010Cet', 'Pet', 'Sob'],
    dayNamesMin: ['N', 'P', 'T', 'S', '\u010C', 'P ', 'S'],
    weekHeader: 'Teden',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Samo \u010Das',
    timeText: '\u010Cas',
    hourText: '\u010Cas',
    minuteText: 'Minute',
    secondText: 'Sekunde',
    currentText: 'danes',
    ampm: false,
    month: 'mesec',
    week: 'teden',
    day: 'dan',
    allDayText: 'Cel dan'
};

// Spanish
PrimeFaces.locales['es'] = {
    closeText: 'Cerrar',
    prevText: 'Anterior',
    nextText: 'Siguiente',
    monthNames: ['Enero','Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
    monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
    dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
    dayNamesShort: ['Dom','Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
    dayNamesMin: ['D','L','M','X','J','V','S'],
    weekHeader: 'Semana',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Sólo hora',
    timeText: 'Tiempo',
    hourText: 'Hora',
    minuteText: 'Minuto',
    secondText: 'Segundo',
    currentText: 'Fecha actual',
    ampm: false,
    month: 'Mes',
    week: 'Semana',
    day: 'Día',
    allDayText : 'Todo el día'
};

// Swedish
PrimeFaces.locales ['sv_SE'] = {
    closeText: 'Stäng',
    prevText: 'Föregående',
    nextText: 'Nästa',
    monthNames: ['januari', 'februari', 'mars', 'april', 'maj', 'juni', 'juli', 'augusti', 'september', 'oktober', 'november', 'december' ],
    monthNamesShort: ['jan', 'feb', 'mar', 'apr', 'maj', 'jun', 'jul', 'aug', 'sep', 'okt', 'nov', 'dec' ],
    dayNames: ['söndag', 'måndag', 'tisdag', 'onsdag', 'torsdag', 'fredag', 'lördag'],
    dayNamesShort: ['sön', 'mån', 'tis', 'ons', 'tor', 'fre', 'lör'],
    dayNamesMin: ['sö', 'må', 'ti', 'on', 'to', 'fr', 'lö'],
    weekHeader: 'Vecka',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Endast tid',
    timeText: 'Tid',
    hourText: 'timmar',
    minuteText: 'minuter',
    secondText: 'sekunder',
    currentText: 'Nuvarande datum',
    ampm: false,
    month: 'månad',
    week: 'vecka',
    day: 'dag',
    allDayText: 'Hela dagen'
};

// Traditional Chinese
PrimeFaces.locales['zh_TW'] = {
    closeText: '關閉',
    prevText: '上個月',
    nextText: '下個月',
    currentText: '今天',
    monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
    monthNamesShort: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
    dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
    dayNamesShort: ['日','一','二','三','四','五','六'],
    dayNamesMin: ['日','一','二','三','四','五','六'],
    weekHeader: '周',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: true,
    yearSuffix: '', // 年
    timeOnlyTitle: '僅時間',
    timeText: '時間',
    hourText: '時',
    minuteText: '分',
    secondText: '秒',
    ampm: false,
    month: '月',
    week: '周',
    day: '日',
    allDayText : '全天'
};

// Turkish
PrimeFaces.locales['tr'] = {
    closeText: 'kapat',
    prevText: 'geri',
    nextText: 'ileri',
    currentText: 'bugün',
    monthNames: ['Ocak','Şubat','Mart','Nisan','Mayıs','Haziran','Temmuz','Ağustos','Eylül','Ekim','Kasım','Aralık'],
    monthNamesShort: ['Oca','Şub','Mar','Nis','May','Haz', 'Tem','Ağu','Eyl','Eki','Kas','Ara'],
    dayNames: ['Pazar','Pazartesi','Salı','Çarşamba','Perşembe','Cuma','Cumartesi'],
    dayNamesShort: ['Pz','Pt','Sa','Ça','Pe','Cu','Ct'],
    dayNamesMin: ['Pz','Pt','Sa','Ça','Pe','Cu','Ct'],
    weekHeader: 'Hf',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Zaman Seçiniz',
    timeText: 'Zaman',
    hourText: 'Saat',
    minuteText: 'Dakika',
    secondText: 'Saniye',
    ampm: false,
    month: 'Ay',
    week: 'Hafta',
    day: 'Gün',
    allDayText : 'Tüm Gün'
};

// Vietnamese
PrimeFaces.locales['vi'] = {
    closeText: 'Tắt',
    prevText: 'Tháng trước',
    nextText: 'Tháng sau',
    monthNames: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12'],
    monthNamesShort: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10', 'Tháng 11', 'Tháng 12' ],
    dayNames: ['Chúa Nhựt', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'],
    dayNamesShort: ['CN', 'Hai', 'Ba', 'Tư', 'Năm', 'Sáu', 'Bảy'],
    dayNamesMin: ['CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7'],
    weekHeader: 'Tuần',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'Chọn giờ',
    timeText: 'Giờ',
    hourText: 'Giờ',
    minuteText: 'Phút',
    secondText: 'Giây',
    currentText: 'Giờ hiện hành',
    ampm: false,
    month: 'Tháng',
    week: 'Tuần',
    day: 'Ngày',
    allDayText: 'Cả ngày'
};

// Georgian
PrimeFaces.locales ['ge'] = {
    closeText: 'დახურვა',
    prevText: 'წინა',
    nextText: 'შემდეგი',
    monthNames: ['იანვარი', 'თებერვალი', 'მარტი', 'აპრილი', 'მაისი', 'ივნისი', 'ივლისი', 'აგვისტო', 'სექტემბერი', 'ოქტომბერი', 'ნოემბერი', 'დეკემბერი' ],
    monthNamesShort: ['იან', 'თებ', 'მარ', 'აპრ', 'მაი', 'ივნ', 'ივლ', 'აგვ', 'სექ', 'ოქტ', 'ნოვ', 'დეკ' ],
    dayNames: ['კვირა', 'ორშაბათი', 'სამშაბათი', 'ოთხშაბათი', 'ხუთშაბათი', 'პარასკევი', 'შაბათი'],
    dayNamesShort: ['კვ', 'ორშ', 'სამშ', 'ოთხშ', 'ხუთშ', 'პარ', 'შაბ'],
    dayNamesMin: ['კვი', 'ორშ', 'სამ', 'ოთხ', 'ხუთ', 'პარ', 'შაბ'],
    weekHeader: 'კვირა',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix:'',
    timeOnlyTitle: 'მხოლოდ დრო',
    timeText: 'დრო',
    hourText: 'საათი',
    minuteText: 'წუთი',
    secondText: 'წამი',
    currentText: 'დღევანდელი თარიღი',
    ampm: false,
    month: 'თვე',
    week: 'კვირა',
    day: 'დღე',
    allDayText: 'ყველა დღე',
    messages: {  //optional for Client Side Validation
        'javax.faces.component.UIInput.REQUIRED': '{0}: შეცდომა: ველის შევსება აუცილებელია.'
    }
};

// Ukrainian
PrimeFaces.locales ['uk'] = {
    closeText: 'Закрити',
    prevText: 'Назад',
    nextText: 'Вперед',
    monthNames: ['Січень', 'Лютий', 'Березень', 'Квітень', 'Травень', 'Червень', 'Липень', 'Серпень', 'Вересень', 'Жовтень', 'Листопад', 'Грудень'],
    monthNamesShort: ['Січ', 'Лют', 'Бер', 'Квіт', 'Трав', 'Черв', 'Лип', 'Серп', 'Вер', 'Жовт', 'Лист', 'Груд'],
    dayNames: ['Неділя', 'Понеділок', 'Вівторок', 'Середа', 'Четвер', "П'ятниця", 'Субота'],
    dayNamesShort: ['Нед', 'Пон', 'Вівт', 'Сер', 'Чет', "П'ят", 'Суб'],
    dayNamesMin: ['Н', 'П', 'В', 'С ', 'Ч', 'П', 'Сб'],
    weekHeader: 'Неділя',
    firstDay: 1,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Тільки час',
    timeText: 'Час',
    hourText: 'Година',
    minuteText: 'Хвилина',
    secondText: 'Секунда',
    currentText: 'Сьогодні',
    ampm: false,
    month: 'Місяць',
    week: 'тиждень',
    day: 'День',
    allDayText: 'Весь день'
};