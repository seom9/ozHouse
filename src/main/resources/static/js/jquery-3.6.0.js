/*!
 * jQuery 자바스크립트 라이브러리 v3.6.0
 * https://jquery.com/
 *
 * Sizzle.js 포함
 * https://sizzlejs.com/
 *
 * 저작권 OpenJS Foundation 및 기타 기여자
 * MIT 라이센스에 따라 출시됨
 * https://jquery.org/license
 *
 * 날짜: 2021-03-02T17:08Z
 */
( 함수( 전역, 팩토리 ) {

	"엄격하게 사용하세요";

	if ( typeof 모듈 === "객체" && typeof module.exports === "객체" ) {

		// 적절한 `window`가 있는 CommonJS 및 CommonJS와 유사한 환경의 경우
		// 존재하는 경우 팩토리를 실행하고 jQuery를 가져옵니다.
		// `문서`가 있는 `창`이 없는 환경의 경우
		// (예: Node.js), 팩토리를 module.exports로 노출합니다.
		// 이는 실제 `창` 생성의 필요성을 강조합니다.
		// 예: var jQuery = require("jquery")(window);
		// 자세한 내용은 티켓 #14549를 참조하세요.
		module.exports = global.document ?
			공장(글로벌, true):
			함수( w ) {
				if ( !w.document ) {
					throw new Error( "jQuery에는 문서가 있는 창이 필요합니다." );
				}
				공장 반환( w );
			};
	} 또 다른 {
		공장(글로벌);
	}

// 창이 아직 정의되지 않은 경우 이를 전달합니다.
} )( 창 유형 !== "정의되지 않음" ? window : this, function( window, noGlobal ) {

// Edge <= 12 - 13+, Firefox <=18 - 45+, IE 10 - 11, Safari 5.1 - 9+, iOS 6 - 9.1
// 엄격하지 않은 코드(예: ASP.NET 4.5)가 엄격 모드에 액세스할 때 예외를 발생시킵니다.
//args.callee.caller(trac-13335). 하지만 jQuery 3.0(2016)부터는 엄격 모드가 일반화되어야 합니다.
// 이러한 모든 시도는 try 블록에서 보호될 만큼 충분합니다.
"엄격하게 사용하세요";

var arr = [];

var getProto = Object.getPrototypeOf;

var 슬라이스 = arr.slice;

var flat = arr.flat ? 함수( 배열 ) {
	return arr.Flat.call( 배열 );
} : 함수( 배열 ) {
	return arr.concat.apply( [], array );
};


var push = arr.push;

var indexOf = arr.indexOf;

var class2type = {};

var toString = class2type.toString;

var hasOwn = class2type.hasOwnProperty;

var fnToString = hasOwn.toString;

var ObjectFunctionString = fnToString.call( Object );

var 지원 = {};

var isFunction = 함수 isFunction( obj ) {

		// 지원: 크롬 <=57, 파이어폭스 <=52
		// 일부 브라우저에서는 typeof가 HTML <object> 요소에 대해 "function"을 반환합니다.
		// (즉, `typeof document.createElement( "object" ) === "function"`).
		// 우리는 *모든* DOM 노드를 함수로 분류하고 싶지 않습니다.
		// 지원: QtWeb <=3.8.5, WebKit <=534.34, wkhtmltopdf 도구 <=0.12.5
		// 또한 이전 WebKit의 경우 typeof는 HTML 컬렉션에 대해 "함수"를 반환합니다.
		// (예: `typeof document.getElementsByTagName("div") === "function"`). (gh-4756)
		return typeof obj === "function" && typeof obj.nodeType !== "number" &&
			typeof obj.item !== "함수";
	};


var isWindow = 함수 isWindow( obj ) {
		return obj != null && obj === obj.window;
	};


var 문서 = window.document;



	var PreservedScriptAttributes = {
		유형: 사실,
		소스: 사실,
		논스: 사실,
		noModule: 사실
	};

	함수 DOMeval(코드, 노드, 문서) {
		문서 = 문서 || 문서;

		var i, 발,
			script = doc.createElement( "script" );

		script.text = 코드;
		if (노드) {
			for(preservedScriptAttributes의 i) {

				// 지원: Firefox 64+, Edge 18+
				// 일부 브라우저는 스크립트에서 "nonce" 속성을 지원하지 않습니다.
				// 반면에 `getAttribute`를 사용하는 것만으로는 충분하지 않습니다.
				// `nonce` 속성은 언제든지 빈 문자열로 재설정됩니다.
				// 브라우징 컨텍스트가 연결됩니다.
				// https://github.com/whatwg/html/issues/2369 참조
				// https://html.spec.whatwg.org/#nonce-attributes 참조
				// `node.getAttribute` 검사가 추가되었습니다.
				// nonce가 포함된 노드를 위조할 수 있도록 `jQuery.globalEval`
				// 객체를 통해.
				val = 노드[ i ] || node.getAttribute && node.getAttribute( i );
				if ( 발 ) {
					script.setAttribute( i, val );
				}
			}
		}
		doc.head.appendChild(스크립트).parentNode.removeChild(스크립트);
	}


함수 toType(obj) {
	if (obj == null ) {
		반환 obj + "";
	}

	// 지원: Android <=2.3 전용(RegExp 기능)
	return typeof obj === "객체" || typeof obj === "함수" ?
		class2type[ toString.call( obj ) ] || "물체" :
		객체 유형;
}
/* 전역 기호 */
// .eslintrc.json에서 이 전역을 정의하면 전역을 사용할 위험이 있습니다.
// 다른 곳에서는 보호되지 않으므로 이 모듈에 대해서만 전역을 정의하는 것이 더 안전해 보입니다.



var
	버전 = "3.6.0",

	// jQuery의 로컬 복사본을 정의합니다.
	jQuery = 함수(선택자, 컨텍스트) {

		// jQuery 객체는 실제로 '향상된' 초기화 생성자일 뿐입니다.
		// jQuery가 호출되면 초기화가 필요합니다(포함되지 않은 경우 오류가 발생하도록 허용).
		return new jQuery.fn.init( 선택기, 컨텍스트 );
	};

jQuery.fn = jQuery.prototype = {

	// 현재 사용 중인 jQuery 버전
	jquery: 버전,

	생성자: jQuery,

	// jQuery 객체의 기본 길이는 0입니다.
	길이: 0,

	toArray: 함수() {
		return Slice.call( this );
	},

	// 일치하는 요소 집합에서 N번째 요소를 가져옵니다. 또는
	// 일치하는 전체 요소 세트를 깨끗한 배열로 가져옵니다.
	가져오기: 함수( 숫자 ) {

		// 깨끗한 배열의 모든 요소를 ​​반환합니다.
		if (숫자 == null) {
			return Slice.call( this );
		}

		// 세트에서 하나의 요소만 반환
		숫자 < 0을 반환합니까? this[ 숫자 + this.length ] : this[ 숫자 ];
	},

	// 요소 배열을 가져와서 스택에 푸시합니다.
	// (새로 일치하는 요소 세트 반환)
	pushStack: 함수( 요소 ) {

		// 새로운 jQuery 일치 요소 세트를 빌드합니다.
		var ret = jQuery.merge( this.constructor(), elems );

		// 이전 객체를 스택에 참조로 추가합니다.
		ret.prevObject = this;

		// 새로 형성된 요소 세트를 반환합니다.
		반환 ret;
	},

	// 일치하는 세트의 모든 요소에 대해 콜백을 실행합니다.
	각각: 함수( 콜백 ) {
		return jQuery.each( this, callback );
	},

	지도: 함수(콜백) {
		return this.pushStack( jQuery.map( this, function( elem, i ) {
			return callback.call( elem, i, elem );
		} ) );
	},

	슬라이스: 함수() {
		return this.pushStack( Slice.apply( this, 인수 ) );
	},

	첫 번째: 함수() {
		return this.eq( 0 );
	},

	마지막: 함수() {
		return this.eq( -1 );
	},

	짝수: 함수() {
		return this.pushStack( jQuery.grep( this, function( _elem, i ) {
			반환 ( i + 1 ) % 2;
		} ) );
	},

	홀수: 함수() {
		return this.pushStack( jQuery.grep( this, function( _elem, i ) {
			나는 % 2를 반환합니다;
		} ) );
	},

	eq: 함수( i ) {
		var len = this.length,
			j = +i + ( i < 0 ? len : 0 );
		return this.pushStack( j >= 0 && j < len ? [ this[ j ] ] : [] );
	},

	끝: 함수() {
		return this.prevObject || this.constructor();
	},

	// 내부용으로만 사용됩니다.
	// jQuery 메서드가 아닌 배열의 메서드처럼 동작합니다.
	밀어 밀어,
	정렬: arr.sort,
	스플라이스: arr.splice
};

jQuery.extend = jQuery.fn.extend = function() {
	var 옵션, 이름, src, 복사, copyIsArray, 복제,
		대상 = 인수[ 0 ] || {},
		나는 = 1,
		길이 = 인수.길이,
		깊은 = 거짓;

	// 깊은 복사 상황을 처리합니다.
	if ( typeof target === "boolean" ) {
		깊은 = 목표;

		// 부울과 대상을 건너뜁니다.
		대상 = 인수[ i ] || {};
		나++;
	}

	// 대상이 문자열 등인 경우 처리(딥 카피에서 가능)
	if ( typeof target !== "object" && !isFunction( target ) ) {
		대상 = {};
	}

	// 하나의 인수만 전달되면 jQuery 자체를 확장합니다.
	if ( i === 길이 ) {
		대상=이것;
		나--;
	}

	for ( ; i < 길이; i++ ) {

		// null이 아니거나 정의되지 않은 값만 처리합니다.
		if ( ( 옵션 = 인수[ i ] ) != null ) {

			// 기본 객체 확장
			for ( 옵션의 이름 ) {
				복사 = 옵션[이름];

				// Object.prototype 오염 방지
				//끝나지 않는 루프 방지
				if ( 이름 === "__proto__" || 대상 === 복사 ) {
					계속하다;
				}

				// 일반 객체나 배열을 병합하는 경우 재귀합니다.
				if ( deep && copy && ( jQuery.isPlainObject( copy ) ||
					( copyIsArray = Array.isArray( 복사 ) ) ) ) {
					src = 대상[이름];

					// 소스 값에 대한 적절한 유형을 확인합니다.
					if ( copyIsArray && !Array.isArray( src ) ) {
						클론 = [];
					} else if ( !copyIsArray && !jQuery.isPlainObject( src ) ) {
						클론 = {};
					} 또 다른 {
						클론 = src;
					}
					copyIsArray = 거짓;

					// 원본 객체를 이동하지 말고 복제하세요.
					target[ 이름 ] = jQuery.extend( deep, clone, copy );

				// 정의되지 않은 값을 가져오지 마세요.
				} else if ( 복사 !== 정의되지 않음 ) {
					대상[이름] = 복사;
				}
			}
		}
	}

	// 수정된 객체를 반환합니다.
	반환 대상;
};

jQuery.확장({

	// 페이지의 각 jQuery 복사본에 대해 고유합니다.
	Expando: "jQuery" + ( 버전 + Math.random() ).replace( /\D/g, "" ),

	// 준비된 모듈 없이 jQuery가 준비되었다고 가정합니다.
	isReady: 사실,

	오류: 함수( msg ) {
		새로운 오류 발생( msg );
	},

	놉: 함수() {},

	isPlainObject: 함수( obj ) {
		var 프로토, Ctor;

		// 명백한 부정 감지
		// 호스트 객체를 포착하기 위해 jQuery.type 대신 toString을 사용합니다.
		if ( !obj || toString.call( obj ) !== "[객체 객체]" ) {
			거짓을 반환;
		}

		proto = getProto(obj);

		// 프로토타입이 없는 객체(예: `Object.create( null )`)는 일반 객체입니다.
		if ( !proto ) {
			사실을 반환;
		}

		// 프로토타입이 있는 객체는 전역 객체 함수에 의해 생성된 경우 일반 객체입니다.
		Ctor = hasOwn.call( proto, "constructor" ) && proto.constructor;
		return typeof Ctor === "function" && fnToString.call( Ctor ) === ObjectFunctionString;
	},

	isEmptyObject: 함수( obj ) {
		변수 이름;

		for(obj의 이름) {
			거짓을 반환;
		}
		사실을 반환;
	},

	// 제공된 컨텍스트에서 스크립트를 평가합니다. 다시 글로벌로 돌아갑니다
	// 지정하지 않은 경우.
	globalEval: 함수(코드, 옵션, 문서) {
		DOMeval( code, { nonce: 옵션 && options.nonce }, doc );
	},

	각각: 함수( obj, 콜백 ) {
		변수 길이, i = 0;

		if ( isArrayLike( obj ) ) {
			길이 = obj.길이;
			for ( ; i < 길이; i++ ) {
				if ( callback.call( obj[ i ], i, obj[ i ] ) === false ) {
					부서지다;
				}
			}
		} 또 다른 {
			for ( i in obj ) {
				if ( callback.call( obj[ i ], i, obj[ i ] ) === false ) {
					부서지다;
				}
			}
		}

		반환 객체;
	},

	// 결과는 내부용으로만 사용됩니다.
	makeArray: 함수( arr, 결과 ) {
		var ret = 결과 || [];

		if (arr != null ) {
			if ( isArrayLike( Object( arr ) ) ) {
				jQuery.merge(ret,
					arr 유형 === "문자열" ?
						[ 도착 ] : 도착
				);
			} 또 다른 {
				push.call(ret,arr);
			}
		}

		반환 ret;
	},

	inArray: 함수( elem, arr, i ) {
		반환 arr == null ? -1 : indexOf.call( arr, elem, i );
	},

	// 지원: Android <=4.0 전용, PhantomJS 1 전용
	// push.apply(_, arraylike)는 고대 WebKit에서 발생합니다.
	병합: 함수(첫 번째, 두 번째) {
		var len = +초.길이,
			j = 0,
			i = 첫 번째.길이;

		for ( ; j < len; j++ ) {
			첫 번째[ i++ ] = 두 번째[ j ];
		}

		첫 번째.길이 = i;

		먼저 돌아가세요.
	},

	grep: 함수(요소, 콜백, 반전) {
		var 콜백역,
			일치 = [],
			나는 = 0,
			길이 = elems.length,
			callbackExpect = !invert;

		// 배열을 탐색하고 항목만 저장합니다.
		// 유효성 검사기 함수를 전달합니다.
		for ( ; i < 길이; i++ ) {
			callbackInverse = !callback( elems[ i ], i );
			if ( callbackInverse !== callbackExpect ) {
				match.push( elems[ i ] );
			}
		}

		일치 항목을 반환합니다.
	},

	// arg는 내부용으로만 사용됩니다.
	지도: 함수(요소, 콜백, 인수) {
		변수 길이, 값,
			나는 = 0,
			ret = [];

		// 배열을 살펴보고 각 항목을 새로운 값으로 변환합니다.
		if ( isArrayLike( elems ) ) {
			길이 = elems.length;
			for ( ; i < 길이; i++ ) {
				value = 콜백( elems[ i ], i, arg );

				if (값 != null ) {
					ret.push(값);
				}
			}

		// 객체의 모든 키를 살펴봅니다.
		} 또 다른 {
			for ( i in elems ) {
				value = 콜백( elems[ i ], i, arg );

				if (값 != null ) {
					ret.push(값);
				}
			}
		}

		// 중첩된 배열을 평면화합니다.
		플랫을 반환(ret);
	},

	// 객체에 대한 전역 GUID 카운터
	가이드: 1,

	// jQuery.support는 Core에서 사용되지 않지만 다른 프로젝트에서는
	// 속성이 있으므로 존재해야 합니다.
	지원하다: 지원하다
} );

if ( 기호 유형 === "함수" ) {
	jQuery.fn[ Symbol.iterator ] = arr[ Symbol.iterator ];
}

// class2type 맵을 채웁니다.
jQuery.each( "부울 숫자 문자열 함수 배열 날짜 RegExp 개체 오류 기호".split( " " ),
	함수( _i, 이름 ) {
		class2type[ "[object " + name + "]" ] = name.toLowerCase();
	} );

함수 isArrayLike( obj ) {

	// 지원: 실제 iOS 8.2만 해당(시뮬레이터에서는 재현 불가능)
	// JIT 오류 방지를 위해 사용되는 `in` 검사(gh-2145)
	// hasOwn은 거짓 부정으로 인해 여기서 사용되지 않습니다.
	// IE의 Nodelist 길이 관련
	var 길이 = !!obj && obj && obj.length의 "길이",
		유형 = toType(obj);

	if ( isFunction( obj ) || isWindow( obj ) ) {
		거짓을 반환;
	}

	반환 유형 === "배열" || 길이 === 0 ||
		typeof length === "number" && length > 0 && ( length - 1 ) in obj;
}
var 지글지글 =
/*!
 * 지글지글 CSS 선택기 엔진 v2.3.6
 * https://sizzlejs.com/
 *
 * 저작권 JS 재단 및 기타 기여자
 * MIT 라이센스에 따라 출시됨
 * https://js.foundation/
 *
 * 날짜: 2021-02-16
 */
( 함수( 창 ) {
내가,
	지원하다,
	특급,
	getText,
	isXML,
	토큰화하다,
	엮다,
	선택하다,
	가장 바깥쪽컨텍스트,
	정렬입력,
	중복됨,

	// 로컬 문서 변수
	세트문서,
	문서,
	문서 요소,
	문서IsHTML,
	rbuggyQSA,
	rbuggy일치,
	성냥,
	포함,

	// 인스턴스별 데이터
	Expando = "지글지글" + 1 * 새 날짜(),
	선호Doc = window.document,
	디런 = 0,
	완료 = 0,
	classCache = createCache(),
	tokenCache = createCache(),
	컴파일러Cache = createCache(),
	nonnativeSelectorCache = createCache(),
	sortOrder = 함수( a, b ) {
		if ( a === b ) {
			hasDuplicate = 사실;
		}
		0을 반환합니다.
	},

	// 인스턴스 메소드
	hasOwn = ( {} ).hasOwnProperty,
	도착 = [],
	팝 = arr.pop,
	pushNative = arr.push,
	푸시 = arr.push,
	슬라이스 = arr.슬라이스,

	// 네이티브보다 빠르므로 제거된 indexOf를 사용합니다.
	// https://jsperf.com/thor-indexof-vs-for/5
	indexOf = 함수( 목록, elem ) {
		변수 i = 0,
			len = 목록.길이;
		for ( ; i < len; i++ ) {
			if ( 목록[ i ] === elem ) {
				내가 반환;
			}
		}
		-1을 반환합니다.
	},

	booleans = "선택됨|선택됨|비동기|자동 초점|자동 재생|제어|지연|비활성화됨|숨겨짐|" +
		"ismap|loop|multiple|open|readonly|required|scoped",

	// 정규식

	// http://www.w3.org/TR/css3-selectors/#whitespace
	공백 = "[\\x20\\t\\r\\n\\f]",

	// https://www.w3.org/TR/css-syntax-3/#ident-token-diagram
	식별자 = "(?:\\\\[\\da-fA-F]{1,6}" + 공백 +
		"?|\\\\[^\\r\\n\\f]|[\\w-]|[^\0-\\x7f])+",

	// 속성 선택기: http://www.w3.org/TR/selectors/#attribute-selectors
	속성 = "\\[" + 공백 + "*(" + 식별자 + ")(?:" + 공백 +

		// 연산자(캡처 2)
		"*([*^$|!~]?=)" + 공백 +

		// "속성 값은 CSS 식별자여야 합니다. [캡처 5]
		// 또는 문자열 [캡처 3 또는 캡처 4]"
		"*(?:'((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\\"] )*)\"|(" + 식별자 + "))|)" +
		공백 + "*\\]",

	의사 = ":(" + 식별자 + ")(?:\\((" +

		// preFilter에서 토큰화가 필요한 선택기 수를 줄이려면 인수를 선호하세요.
		// 1. 인용됨(캡처 3, 캡처 4 또는 캡처 5)
		"('((?:\\\\.|[^\\\\'])*)'|\"((?:\\\\.|[^\\\\\"])*) \")|" +

		// 2. 단순(캡쳐 6)
		"((?:\\\\.|[^\\\\()[\\]]|" + 속성 + ")*)|" +

		// 3. 그 밖의 것(캡처 2)
		".*" +
		")\\)|)",

	// 선행 및 이스케이프 처리되지 않은 후행 공백, 후자 앞에 있는 공백이 아닌 일부 문자 캡처
	rwhitespace = 새로운 RegExp( 공백 + "+", "g" ),
	rtrim = new RegExp( "^" + 공백 + "+|((?:^|[^\\\\])(?:\\\\.)*)" +
		공백 + "+$", "g" ),

	rcomma = new RegExp( "^" + 공백 + "*," + 공백 + "*" ),
	rcombinators = new RegExp( "^" + 공백 + "*([>+~]|" + 공백 + ")" + 공백 +
		"*" ),
	rdescend = 새로운 RegExp( 공백 + "|>" ),

	rpseudo = 새로운 RegExp( 의사 ),
	riderifier = 새로운 RegExp( "^" + 식별자 + "$" ),

	matchExpr = {
		"ID": new RegExp( "^#(" + 식별자 + ")" ),
		"CLASS": 새로운 RegExp( "^\\.(" + 식별자 + ")" ),
		"TAG": 새로운 RegExp( "^(" + 식별자 + "|[*])" ),
		"ATTR": 새로운 RegExp( "^" + 속성 ),
		"의사": 새로운 RegExp( "^" + 의사 ),
		"CHILD": new RegExp( "^:(only|first|last|nth|nth-last)-(child|of-type)(?:\\(" +
			공백 + "*(짝수|홀수|(([+-]|)(\\d*)n|)" + 공백 + "*(?:([+-]|)" +
			공백 + "*(\\d+)|))" + 공백 + "*\\)|)", "i" ),
		"bool": new RegExp( "^(?:" + 부울 + ")$", "i" ),

		// .is()를 구현하는 라이브러리에서 사용
		// `select`에서 POS 매칭에 사용합니다.
		"needsContext": 새로운 RegExp( "^" + 공백 +
			"*[>+~]|:(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + 공백 +
			"*((?:-\\d)?\\d*)" + 공백 + "*\\)|)(?=[^-]|$)", "i" )
	},

	rhtml = /HTML$/i,
	rinputs = /^(?:input|select|textarea|button)$/i,
	r헤더 = /^h\d$/i,

	기본 = /^[^{]+\{\s*\[기본 \w/,

	// 쉽게 구문 분석/검색 가능한 ID, TAG 또는 CLASS 선택기
	rquickExpr = /^(?:#([\w-]+)|(\w+)|\.([\w-]+))$/,

	rsibling = /[+~]/,

	// CSS 이스케이프
	// http://www.w3.org/TR/CSS21/syndata.html#escaped-characters
	runescape = new RegExp( "\\\\[\\da-fA-F]{1,6}" + 공백 + "?|\\\\([^\\r\\n\\f])" , "g" ),
	funescape = function( escape, nonHex ) {
		var high = "0x" + escape.slice( 1 ) - 0x10000;

		nonHex를 반환 하시겠습니까?

			// 16진수가 아닌 이스케이프 시퀀스에서 백슬래시 접두사를 제거합니다.
			비Hex :

			// 16진수 이스케이프 시퀀스를 인코딩된 유니코드 코드 포인트로 바꿉니다.
			// 지원: IE <=11+
			// BMP(Basic Multilingual Plane) 외부 값의 경우 수동으로
			// 대리 쌍
			높음 < 0?
				String.fromCharCode( 높음 + 0x10000 ) :
				String.fromCharCode(높음 >> 10 | 0xD800, 높음 & 0x3FF | 0xDC00 );
	},

	// CSS 문자열/식별자 직렬화
	// https://drafts.csswg.org/cssom/#common-serializing-idioms
	rcssescape = /([\0-\x1f\x7f]|^-?\d)|^-$|[^\0-\x1f\x7f-\uFFFF\w-]/g,
	fcssescape = 함수(ch, asCodePoint) {
		if ( asCodePoint ) {

			// U+0000 NULL은 U+FFFD REPLACEMENT CHARACTER가 됩니다.
			if ( ch === "\0" ) {
				"\uFFFD"를 반환합니다.
			}

			// 제어 문자와 (위치에 따라) 숫자는 코드 포인트로 이스케이프됩니다.
			return ch.slice( 0, -1 ) + "\\" +
				ch.charCodeAt( ch.length - 1 ).toString( 16 ) + " ";
		}

		// 기타 잠재적으로 특수한 ASCII 문자는 백슬래시로 이스케이프됩니다.
		"\\" + ch를 반환합니다.
	},

	// iframe에 사용됨
	// setDocument() 참조
	// 함수 래퍼를 제거하면 "권한 거부"가 발생합니다.
	// IE에서 오류가 발생했습니다.
	unloadHandler = 함수() {
		setDocument();
	},

	inDisabledFieldset = addCombinator(
		함수(요소) {
			return elem.disabled === true && elem.nodeName.toLowerCase() === "fieldset";
		},
		{ 디렉토리: "parentNode", 다음: "범례" }
	);

// push.apply( _, NodeList )에 맞게 최적화
노력하다 {
	푸시.적용(
		( arr = Slice.call( PreferredDoc.childNodes ) ),
		선호하는Doc.childNodes
	);

	// 지원: 안드로이드<4.0
	// 자동으로 실패하는 push.apply를 감지합니다.
	// eslint-disable-next-line 사용하지 않는 표현식
	arr[ PreferredDoc.childNodes.length ].nodeType;
} 잡기 ( 전자 ) {
	push = { 적용: arr.length ?

		// 가능하면 슬라이스를 활용합니다.
		함수(대상, 엘스) {
			pushNative.apply( target, Slice.call( els ) );
		} :

		// 지원: IE<9
		// 그렇지 않으면 직접 추가
		함수(대상, 엘스) {
			var j = 목표 길이,
				나는 = 0;

			// NodeList.length를 신뢰할 수 없습니다.
			while ( ( target[ j++ ] = els[ i++ ] ) ) {}
			target.length = j - 1;
		}
	};
}

function Sizzle( 선택기, 컨텍스트, 결과, 시드 ) {
	var m, i, elem, nid, 일치, 그룹, newSelector,
		newContext = 컨텍스트 && context.ownerDocument,

		// context의 기본값은 document이므로 nodeType의 기본값은 9입니다.
		nodeType = 컨텍스트 ? context.nodeType : 9;

	결과 = 결과 || [];

	// 유효하지 않은 선택기 또는 컨텍스트가 있는 호출에서 조기에 반환됩니다.
	if ( 선택기 유형 !== "string" || !selector ||
		nodeType !== 1 && nodeType !== 9 && nodeType !== 11 ) {

		결과를 반환합니다.
	}

	// HTML 문서에서 (필터와 반대되는) 단축키 찾기 작업을 시도합니다.
	만약 (!씨드) {
		setDocument(컨텍스트);
		맥락 = 맥락 || 문서;

		if ( documentIsHTML ) {

			// 선택기가 충분히 간단한 경우 "get*By*" DOM ​​메서드를 사용해 보세요.
			// (메서드가 존재하지 않는 DocumentFragment 컨텍스트는 제외)
			if ( nodeType !== 11 && ( match = rquickExpr.exec( 선택기 ) ) ) {

				// 아이디 선택자
				if ( ( m = 일치[ 1 ] ) ) {

					// 문서 컨텍스트
					if ( nodeType === 9 ) {
						if ( ( elem = context.getElementById(m ) ) ) {

							// 지원: IE, 오페라, 웹킷
							// TODO: 버전 식별
							// getElementById는 ID 대신 이름으로 요소를 일치시킬 수 있습니다.
							if ( elem.id === m ) {
								결과.푸시(elem);
								결과를 반환합니다.
							}
						} 또 다른 {
							결과를 반환합니다.
						}

					// 요소 컨텍스트
					} 또 다른 {

						// 지원: IE, 오페라, 웹킷
						// TODO: 버전 식별
						// getElementById는 ID 대신 이름으로 요소를 일치시킬 수 있습니다.
						if ( newContext && ( elem = newContext.getElementById( m ) ) &&
							포함(컨텍스트, 요소) &&
							elem.id === m ) {

							결과.푸시(elem);
							결과를 반환합니다.
						}
					}

				// 유형 선택기
				} else if ( 일치[ 2 ] ) {
					push.apply( 결과, context.getElementsByTagName( 선택기 ) );
					결과를 반환합니다.

				// 클래스 선택자
				} else if ( ( m = match[ 3 ] ) && support.getElementsByClassName &&
					context.getElementsByClassName ) {

					push.apply( 결과, context.getElementsByClassName( m ) );
					결과를 반환합니다.
				}
			}

			// querySelectorAll 활용
			if ( support.qsa &&
				!nonnativeSelectorCache[ 선택기 + " " ] &&
				( !rbuggyQSA || !rbuggyQSA.test( 선택기 ) ) &&

				// 지원: IE 8만 해당
				// 객체 요소 제외
				( nodeType !== 1 || context.nodeName.toLowerCase() !== "객체" ) ) {

				newSelector = 선택자;
				newContext = 컨텍스트;

				// qSA는 하위 항목을 평가할 때 범위 지정 루트 외부의 요소를 고려합니다.
				// 우리가 원하는 것이 아닌 자손 연결자.
				// 이러한 경우에는 모든 선택기에 접두사를 추가하여 동작을 해결합니다.
				// 범위 컨텍스트를 참조하는 ID 선택기가 있는 목록입니다.
				// 선행 연결자를 사용할 때도 이 기술을 사용해야 합니다.
				// 이러한 선택자는 querySelectorAll에서 인식되지 않습니다.
				// 이 기술을 제공한 Andrew Dupont에게 감사드립니다.
				if ( nodeType === 1 &&
					( rdescend.test( 선택기 ) || rcombinators.test( 선택기 ) ) ) {

					// 형제 선택자의 컨텍스트를 확장합니다.
					newContext = rsibling.test( 선택기 ) && testContext( context.parentNode ) ||
						문맥;

					// 브라우저가 ID 해킹 대신 :scope를 사용할 수 있습니다.
					// 컨텍스트를 변경하지 않는 경우 이를 지원합니다.
					if ( newContext !== 컨텍스트 || !support.scope ) {

						// 컨텍스트 ID를 캡처하고 필요한 경우 먼저 설정합니다.
						if ( ( nid = context.getAttribute( "id" ) ) ) {
							nid = nid.replace( rcssescape, fcssescape );
						} 또 다른 {
							context.setAttribute( "id", ( nid = Expando ) );
						}
					}

					// 목록의 모든 선택기에 접두사를 붙입니다.
					그룹 = 토큰화(선택기);
					i = 그룹.길이;
					동안( i-- ) {
						그룹[ i ] = ( nid ? "#" + nid : ":scope" ) + " " +
							toSelector( 그룹[ i ] );
					}
					newSelector = groups.join( "," );
				}

				노력하다 {
					push.apply( 결과,
						newContext.querySelectorAll( newSelector )
					);
					결과를 반환합니다.
				} 잡기(qsaError) {
					nonnativeSelectorCache( 선택자, true );
				} 마지막으로 {
					if ( nid === 확장 ) {
						context.removeAttribute( "id" );
					}
				}
			}
		}
	}

	// 다른 모든
	return select( selector.replace( rtrim, "$1" ), 컨텍스트, 결과, 시드 );
}

/**
 * 제한된 크기의 키-값 캐시 생성
 * @returns {function(string, object)} 객체 데이터를 자체적으로 저장한 후 반환합니다.
 * 속성 이름 (공백이 붙은) 문자열 및 (캐시가 Expr.cacheLength보다 큰 경우)
 * 가장 오래된 항목 삭제
 */
함수 createCache() {
	var 키 = [];

	함수 캐시(키, 값) {

		// 네이티브 프로토타입 속성과의 충돌을 피하기 위해 (key + " ")를 사용합니다(문제 #157 참조).
		if (keys.push(key + " " ) > Expr.cacheLength ) {

			// 가장 최근 항목만 유지
			캐시 삭제[keys.shift() ];
		}
		return ( 캐시[ 키 + " " ] = 값 );
	}
	캐시 반환;
}

/**
 * Sizzle에서 특별하게 사용할 기능을 표시하세요.
 * @param {Function} fn 표시할 함수
 */
함수 markFunction(fn) {
	fn[ 확장 ] = true;
	fn을 반환;
}

/**
 * 요소를 사용한 테스트 지원
 * @param {Function} fn 생성된 요소를 전달하고 부울 결과를 반환합니다.
 */
함수 주장( fn ) {
	var el = document.createElement( "fieldset" );

	노력하다 {
		return !!fn(엘);
	} 잡기 ( 전자 ) {
		거짓을 반환;
	} 마지막으로 {

		// 기본적으로 부모로부터 제거
		if (el.parentNode) {
			el.parentNode.removeChild(el );
		}

		// IE에서 메모리 해제
		엘 = 널;
	}
}

/**
 * 지정된 모든 속성에 대해 동일한 핸들러를 추가합니다.
 * @param {String} attrs 파이프로 구분된 속성 목록
 * @param {Function} handler 적용할 메소드
 */
function addHandle( 속성, 핸들러 ) {
	var arr = attrs.split( "|" ),
		i = 배열 ​​길이;

	동안( i-- ) {
		Expr.attrHandle[ arr[ i ] ] = 핸들러;
	}
}

/**
 * 두 형제의 문서 순서를 확인합니다.
 * @param {요소}a
 * @param {요소}b
 * @returns {Number} a가 b보다 앞에 있으면 0보다 작은 값을 반환하고, a가 b 뒤에 오면 0보다 큰 값을 반환합니다.
 */
함수 형제 검사( a, b ) {
	var cur = b && a,
		diff = cur && a.nodeType === 1 && b.nodeType === 1 &&
			a.sourceIndex - b.sourceIndex;

	// 두 노드 모두에서 사용 가능한 경우 IE sourceIndex를 사용합니다.
	만약 ( 차이 ) {
		반환 차이;
	}

	// b가 a 뒤에 오는지 확인
	만약 ( 현재 ) {
		while (( cur = cur.nextSibling ) ) {
			if ( 현재 === b ) {
				-1을 반환합니다.
			}
		}
	}

	반환? 1: -1;
}

/**
 * 입력 유형에 대한 의사에 사용할 함수를 반환합니다.
 * @param {String} 유형
 */
함수 createInputPseudo( 유형 ) {
	반환 함수( elem ) {
		var 이름 = elem.nodeName.toLowerCase();
		반환 이름 === "input" && elem.type === type;
	};
}

/**
 * 버튼 의사에 사용할 함수를 반환합니다.
 * @param {String} 유형
 */
함수 createButtonPseudo( 유형 ) {
	반환 함수( elem ) {
		var 이름 = elem.nodeName.toLowerCase();
		return ( name === "input" || name === "button" ) && elem.type === type;
	};
}

/**
 * :enabled/:disabled에 대해 의사로 사용할 함수를 반환합니다.
 * @param {Boolean} 비활성화됨 :disabled의 경우 true; :활성화의 경우 거짓
 */
함수 createDisabledPseudo( 비활성화 ) {

	// 알려진 :disabled 거짓 긍정: fieldset[disabled] > legend:nth-of-type(n+2) :can-disable
	반환 함수( elem ) {

		// 특정 요소만 :enabled 또는 :disabled와 일치할 수 있습니다.
		// https://html.spec.whatwg.org/multipage/scripting.html#selector-enabled
		// https://html.spec.whatwg.org/multipage/scripting.html#selector-disabled
		if ( elem의 "양식") {

			// 비활성화되지 않은 관련 요소에서 상속된 비활성화 여부를 확인합니다.
			// * 비활성화된 필드 세트에 나열된 양식 관련 요소
			// https://html.spec.whatwg.org/multipage/forms.html#category-listed
			// https://html.spec.whatwg.org/multipage/forms.html#concept-fe-disabled
			// * 비활성화된 optgroup의 옵션 요소
			// https://html.spec.whatwg.org/multipage/forms.html#concept-option-disabled
			// 이러한 모든 요소에는 "form" 속성이 있습니다.
			if ( elem.parentNode && elem.disabled === false ) {

				// 옵션 요소는 존재하는 경우 상위 optgroup을 따릅니다.
				if ( elem의 "레이블") {
					if ( elem.parentNode 의 "레이블" ) {
						return elem.parentNode.disabled === 비활성화됨;
					} 또 다른 {
						return elem.disabled === 비활성화됨;
					}
				}

				// 지원: IE 6 - 11
				// isDisabled 단축키 속성을 사용하여 비활성화된 필드 세트 조상을 확인합니다.
				return elem.isDisabled === 비활성화됨 ||

					// isDisabled가 없는 경우 수동으로 확인
					/* jshint -W018 */
					elem.isDisabled !== !disabled &&
					inDisabledFieldset( elem ) === 비활성화됨;
			}

			return elem.disabled === 비활성화됨;

		// 비활성화된 속성을 신뢰하기 전에 비활성화할 수 없는 요소를 선별해 보십시오.
		// 일부 피해자는 우리의 네트(라벨, 범례, 메뉴, 트랙)에 걸리게 되지만, 그렇게 되어서는 안 됩니다.
		// 부울 값은 물론이고 그 위에도 존재합니다.
		} else if ( elem의 "레이블" ) {
			return elem.disabled === 비활성화됨;
		}

		// 나머지 요소는 :enabled 또는 :disabled가 아닙니다.
		거짓을 반환;
	};
}

/**
 * 위치에 대한 의사에서 사용할 함수를 반환합니다.
 * @param {함수} fn
 */
함수 createPositionalPseudo(fn) {
	return markFunction( 함수( 인수 ) {
		인수 = +인수;
		return markFunction( 함수( 시드, 일치 ) {
			var j,
				matchIndexes = fn( [], seed.length, 인수 ),
				i = matchIndexes.length;

			// 지정된 인덱스에서 찾은 요소를 일치시킵니다.
			동안( i-- ) {
				if ( 시드[ ( j = matchIndexes[ i ] ) ] ) {
					씨앗[ j ] = !( 일치[ j ] = 씨앗[ j ] );
				}
			}
		} );
	} );
}

/**
 * Sizzle 컨텍스트로 노드의 유효성을 확인합니다.
 * @param {요소|객체=} 컨텍스트
 * @returns {Element|Object|Boolean} 허용되는 경우 입력 노드, 그렇지 않으면 거짓 값
 */
함수 testContext(컨텍스트) {
	return context && typeof context.getElementsByTagName !== "정의되지 않음" && context;
}

// 편의를 위해 지원 변수를 노출합니다.
지원 = Sizzle.support = {};

/**
 * XML 노드 감지
 * @param {Element|Object} elem 요소 또는 문서
 * @returns {Boolean} 요소가 HTML이 아닌 XML 노드인 경우 True
 */
isXML = Sizzle.isXML = 함수( elem ) {
	var 네임스페이스 = elem && elem.namespaceURI,
		docElem = elem && ( elem.ownerDocument || elem ).documentElement;

	// 지원: IE <=8
	// iframe 로드 내부와 같이 documentElement가 아직 존재하지 않는 경우 HTML을 가정합니다.
	// https://bugs.jquery.com/ticket/4833
	return !rhtml.test( 네임스페이스 || docElem && docElem.nodeName || "HTML" );
};

/**
 * 현재 문서를 기준으로 문서 관련 변수를 1회 설정
 * @param {Element|Object} [doc] 문서를 설정하는 데 사용할 요소 또는 문서 객체
 * @returns {Object} 현재 문서를 반환합니다.
 */
setDocument = Sizzle.setDocument = function( 노드 ) {
	var hasCompare, 하위 창,
		문서 = 노드 ? node.owner문서 || 노드 : 선호Doc;

	// 문서가 유효하지 않거나 이미 선택된 경우 일찍 반환합니다.
	// 지원: IE 11+, Edge 17 - 18+
	// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
	// 두 개의 문서; 얕은 비교가 작동합니다.
	// eslint-disable-next-line eqeqeq
	if ( doc == 문서 || doc.nodeType !== 9 || !doc.documentElement ) {
		문서 반환;
	}

	// 전역 변수 업데이트
	문서 = 문서;
	docElem = document.documentElement;
	documentIsHTML = !isXML( 문서 );

	// 지원: IE 9 - 11+, Edge 12 - 18+
	// 언로드 후 iframe 문서에 액세스하면 "권한 거부" 오류가 발생함(jQuery #13936)
	// 지원: IE 11+, Edge 17 - 18+
	// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
	// 두 개의 문서; 얕은 비교가 작동합니다.
	// eslint-disable-next-line eqeqeq
	if ( PreferredDoc != 문서 &&
		( subWindow = document.defaultView ) && subWindow.top !== subWindow ) {

		// 지원: IE 11, 엣지
		if ( subWindow.addEventListener ) {
			subWindow.addEventListener( "unload", unloadHandler, false );

		// 지원: IE 9 - 10만 해당
		} else if ( subWindow.attachEvent ) {
			subWindow.attachEvent( "onunload", unloadHandler );
		}
	}

	// 지원: IE 8 - 11+, Edge 12 - 18+, Chrome <=16 - 25 전용, Firefox <=3.6 - 31 전용,
	// Safari 4 - 5 전용, Opera <=11.6 - 12.x 전용
	// IE/Edge 및 이전 브라우저는 :scope 의사 클래스를 지원하지 않습니다.
	// 지원: Safari 6.0만 해당
	// Safari 6.0은 :scope를 지원하지만 거기에는 :root의 별칭이 있습니다.
	support.scope = 주장(함수(엘)) {
		docElem.appendChild( el ).appendChild( document.createElement( "div" ) );
		el.querySelectorAll의 반환 유형 !== "정의되지 않음" &&
			!el.querySelectorAll( ":scope fieldset div" ).length;
	} );

	/* 속성
	------------------------------------- ------- */

	// 지원: IE<8
	// getAttribute가 실제로 속성이 아닌 속성을 반환하는지 확인합니다.
	// (IE8 부울 제외)
	support.attributes = 주장(함수(엘)) {
		el.className = "i";
		return !el.getAttribute( "className" );
	} );

	/* getElement(s)By*
	------------------------------------- ------- */

	// getElementsByTagName("*")이 요소만 반환하는지 확인합니다.
	support.getElementsByTagName = 주장(함수(엘)) {
		el.appendChild( document.createComment( "" ) );
		return !el.getElementsByTagName( "*" ).length;
	} );

	// 지원: IE<9
	support.getElementsByClassName = rnative.test( document.getElementsByClassName );

	// 지원: IE<10
	// getElementById가 요소를 이름으로 반환하는지 확인합니다.
	// 깨진 getElementById 메소드는 프로그래밍 방식으로 설정된 이름을 선택하지 않습니다.
	// 따라서 로터리 getElementsByName 테스트를 사용합니다.
	support.getById = 주장(함수(엘)) {
		docElem.appendChild(el).id = Expando;
		return !document.getElementsByName || !document.getElementsByName(expando).length;
	} );

	// ID 필터 및 찾기
	if (support.getById) {
		Expr.filter[ "ID" ] = 함수( id ) {
			var attrId = id.replace( runescape, funescape );
			반환 함수( elem ) {
				return elem.getAttribute( "id" ) === attrId;
			};
		};
		Expr.find[ "ID" ] = function( id, context ) {
			if ( typeof context.getElementById !== "정의되지 않음" && documentIsHTML ) {
				var elem = context.getElementById(id);
				요소를 반환 ? [ 요소 ] : [];
			}
		};
	} 또 다른 {
		Expr.filter[ "ID" ] = 함수( id ) {
			var attrId = id.replace( runescape, funescape );
			반환 함수( elem ) {
				var node = elem.getAttributeNode 유형 !== "정의되지 않음" &&
					elem.getAttributeNode( "id" );
				return node && node.value === attrId;
			};
		};

		// 지원: IE 6 - 7만 해당
		// getElementById는 찾기 단축키로 신뢰할 수 없습니다.
		Expr.find[ "ID" ] = function( id, context ) {
			if ( typeof context.getElementById !== "정의되지 않음" && documentIsHTML ) {
				var 노드, i, 요소,
					elem = context.getElementById(id);

				if ( 요소 ) {

					// id 속성을 확인합니다.
					node = elem.getAttributeNode( "id" );
					if ( 노드 && node.value === id ) {
						반환 [ 요소 ];
					}

					// getElementsByName으로 대체
					elems = context.getElementsByName(id);
					나는 = 0;
					while ( ( elem = elems[ i++ ] ) ) {
						node = elem.getAttributeNode( "id" );
						if ( 노드 && node.value === id ) {
							반환 [ 요소 ];
						}
					}
				}

				반품 [];
			}
		};
	}

	// 태그
	Expr.find[ "TAG" ] = support.getElementsByTagName ?
		함수( 태그, 컨텍스트 ) {
			if ( typeof context.getElementsByTagName !== "정의되지 않음" ) {
				return context.getElementsByTagName( 태그 );

			// DocumentFragment 노드에는 gEBTN이 없습니다.
			} else if ( support.qsa ) {
				return context.querySelectorAll( 태그 );
			}
		} :

		함수( 태그, 컨텍스트 ) {
			변수 요소,
				tmp = [],
				나는 = 0,

				// 우연의 일치로 (깨진) gEBTN이 DocumentFragment 노드에도 나타납니다.
				결과 = context.getElementsByTagName( 태그 );

			// 가능한 댓글을 필터링합니다.
			if ( 태그 === "*" ) {
				while ( ( elem = 결과[ i++ ] ) ) {
					if ( elem.nodeType === 1 ) {
						tmp.push( elem );
					}
				}

				TMP를 반환;
			}
			결과를 반환합니다.
		};

	// 수업
	Expr.find[ "CLASS" ] = support.getElementsByClassName && function( className, context ) {
		if ( typeof context.getElementsByClassName !== "정의되지 않음" && documentIsHTML ) {
			return context.getElementsByClassName( className );
		}
	};

	/* QSA/matchesSelector
	------------------------------------- ------- */

	// QSA 및 matchSelector 지원

	// matchSelector(:active)는 true일 때 false를 보고합니다(IE9/Opera 11.5).
	rbuggyMatches = [];

	// qSa(:focus)는 true일 때 false를 보고합니다(Chrome 21).
	// 오류를 발생시키는 IE8/9의 버그 때문에 이를 허용합니다.
	// iframe에서 `document.activeElement`에 액세스할 때마다
	// 따라서 IE 오류를 피하기 위해 :focus가 항상 QSA를 통과하도록 허용합니다.
	// https://bugs.jquery.com/ticket/13378 참조
	rbuggyQSA = [];

	if ( ( support.qsa = rnative.test( document.querySelectorAll ) ) ) {

		// QSA 정규식 빌드
		// Diego Perini가 채택한 정규식 전략
		주장(함수(엘)) {

			var 입력;

			// Select는 의도적으로 빈 문자열로 설정됩니다.
			// 이는 IE가 명시적으로 처리하지 않는지 테스트하기 위한 것입니다.
			// 부울 콘텐츠 속성 설정,
			// 존재만으로도 충분하므로
			// https://bugs.jquery.com/ticket/12359
			docElem.appendChild( el ).innerHTML = "<a id='" + Expando + "'></a>" +
				"<select id='" + Expando + "-\r\\' msallowcapture=''>" +
				"<option selected=''></option></select>";

			// 지원: IE8, Opera 11-12.16
			// ^=, $=, *= 다음에 빈 문자열이 오면 아무것도 선택하면 안 됩니다.
			// 테스트 속성은 Opera에서는 알 수 없지만 WinRT에서는 "안전"해야 합니다.
			// https://msdn.microsoft.com/en-us/library/ie/hh465388.aspx#attribute_section
			if ( el.querySelectorAll( "[msallowcapture^='']" ).length ) {
				rbuggyQSA.push( "[*^$]=" + 공백 + "*(?:''|\"\")" );
			}

			// 지원: IE8
			// 부울 속성과 "값"이 올바르게 처리되지 않습니다.
			if ( !el.querySelectorAll( "[선택됨]" ).length ) {
				rbuggyQSA.push( "\\[" + 공백 + "*(?:value|" + 부울 + ")" );
			}

			// 지원: Chrome<29, Android<4.4, Safari<7.0+, iOS<7.0+, PhantomJS<1.9.8+
			if ( !el.querySelectorAll( "[id~=" + Expando + "-]" ).length ) {
				rbuggyQSA.push( "~=" );
			}

			// 지원: IE 11+, Edge 15 - 18+
			// IE 11/Edge는 경우에 따라 `[name='']` 쿼리에서 요소를 찾지 못합니다.
			// 선택이 작동하기 전에 문서에 임시 속성을 추가합니다.
			// 문제 주변.
			// 흥미롭게도 IE 10 이하에서는 문제가 없는 것 같습니다.
			input = document.createElement( "input" );
			input.setAttribute( "이름", "" );
			el.appendChild(입력);
			if ( !el.querySelectorAll( "[name='']" ).length ) {
				rbuggyQSA.push( "\\[" + 공백 + "*이름" + 공백 + "*=" +
					공백 + "*(?:''|\"\")" );
			}

			// Webkit/Opera - :checked는 선택된 옵션 요소를 반환해야 합니다.
			// http://www.w3.org/TR/2011/REC-css3-selectors-20110929/#checked
			// IE8은 여기서 오류를 발생시키고 이후 테스트를 볼 수 없습니다.
			if ( !el.querySelectorAll( ":checked" ).length ) {
				rbuggyQSA.push( ":checked" );
			}

			// 지원: Safari 8+, iOS 8+
			// https://bugs.webkit.org/show_bug.cgi?id=136851
			// 인페이지 `selector#id sibling-combinator selector` 실패
			if ( !el.querySelectorAll( "a#" + Expando + "+*" ).length ) {
				rbuggyQSA.push( ".#.+[+~]" );
			}

			// 지원: Firefox <=3.6 - 5만 해당
			// 이전 Firefox에서는 잘못 이스케이프된 식별자를 사용하지 않습니다.
			el.querySelectorAll( "\\f" );
			rbuggyQSA.push( "[\\r\\n\\f]" );
		} );

		주장(함수(엘)) {
			el.innerHTML = "<a href=''disabled='disabled'></a>" +
				"<selectenabled='disabled'><option/></select>";

			// 지원: Windows 8 기본 앱
			// .innerHTML 할당 중에는 유형 및 이름 속성이 제한됩니다.
			var input = document.createElement( "input" );
			input.setAttribute( "유형", "숨김" );
			el.appendChild(입력).setAttribute( "이름", "D" );

			// 지원: IE8
			// 이름 속성의 대소문자 구분을 적용합니다.
			if ( el.querySelectorAll( "[name=d]" ).length ) {
				rbuggyQSA.push( "이름" + 공백 + "*[*^$|!~]?=" );
			}

			// FF 3.5 - :enabled/:disabled 및 숨겨진 요소(숨겨진 요소는 계속 활성화됨)
			// IE8은 여기서 오류를 발생시키고 이후 테스트를 볼 수 없습니다.
			if ( el.querySelectorAll( ":enabled" ).length !== 2 ) {
				rbuggyQSA.push( ":enabled", ":disabled" );
			}

			// 지원: IE9-11+
			// IE의 :disabled 선택기는 비활성화된 필드 세트의 하위 항목을 선택하지 않습니다.
			docElem.appendChild(el).disabled = true;
			if ( el.querySelectorAll( ":disabled" ).length !== 2 ) {
				rbuggyQSA.push( ":enabled", ":disabled" );
			}

			// 지원: Opera 10 - 11만 해당
			// Opera 10-11은 쉼표 뒤에 올바르지 않은 의사를 표시하지 않습니다.
			el.querySelectorAll( "*,:x" );
			rbuggyQSA.push( ",.*:" );
		} );
	}

	if ( ( support.matchesSelector = rnative.test( ( match = docElem.matches ||
		docElem.webkitMatchesSelector ||
		docElem.mozMatchesSelector ||
		docElem.oMatchesSelector ||
		docElem.msMatchesSelector ) ) ) ) {

		주장(함수(엘)) {

			// matchSelector를 수행할 수 있는지 확인합니다.
			// 연결이 끊긴 노드에서(IE 9)
			support.disconnectedMatch = match.call( el, "*" );

			// 예외로 인해 실패해야 합니다.
			// Gecko는 오류가 없으며 대신 false를 반환합니다.
			match.call( el, "[s!='']:x" );
			rbuggyMatches.push( "!=", pseudos );
		} );
	}

	rbuggyQSA = rbuggyQSA.length && new RegExp( rbuggyQSA.join( "|" ) );
	rbuggyMatches = rbuggyMatches.length && new RegExp( rbuggyMatches.join( "|" ) );

	/* 포함
	------------------------------------- ------- */
	hasCompare = rnative.test( docElem.compareDocumentPosition );

	// 요소에 다른 요소가 포함되어 있음
	// 의도적으로 자체 배타적
	// 마찬가지로 요소는 자신을 포함하지 않습니다.
	포함 = hasCompare || rnative.test(docElem.contains) ?
		함수( a, b ) {
			var adown = a.nodeType === 9 ? a.documentElement : a,
				bup = b && b.parentNode;
			=== bup을 반환 || !!( bup && bup.nodeType === 1 && (
				adown.contains ?
					adown.contains( bup ) :
					a.compareDocumentPosition && a.compareDocumentPosition( bup ) & 16
			) );
		} :
		함수( a, b ) {
			만약 (비) {
				while ( ( b = b.parentNode ) ) {
					if ( b === a ) {
						사실을 반환;
					}
				}
			}
			거짓을 반환;
		};

	/* 정렬
	------------------------------------- ------- */

	// 문서 순서 정렬
	sortOrder = hasCompare ?
	함수( a, b ) {

		// 중복 제거 플래그
		if ( a === b ) {
			hasDuplicate = 사실;
			0을 반환합니다.
		}

		// 하나의 입력에만 CompareDocumentPosition이 있는 경우 메서드 존재를 기준으로 정렬합니다.
		var 비교 = !a.compareDocumentPosition - !b.compareDocumentPosition;
		만약 (비교) {
			반환 비교;
		}

		// 두 입력이 모두 동일한 문서에 속하는 경우 위치를 계산합니다.
		// 지원: IE 11+, Edge 17 - 18+
		// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
		// 두 개의 문서; 얕은 비교가 작동합니다.
		// eslint-disable-next-line eqeqeq
		비교 = ( a.ownerDocument || a ) == ( b.ownerDocument || b ) ?
			a.compareDocumentPosition( b ) :

			// 그렇지 않으면 연결이 끊어진 것을 알 수 있습니다.
			1;

		// 연결이 끊긴 노드
		if (비교 & 1 ||
			( !support.sortDetached && b.compareDocumentPosition( a ) === 비교 ) ) {

			// 선호하는 문서와 관련된 첫 번째 요소를 선택합니다.
			// 지원: IE 11+, Edge 17 - 18+
			// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
			// 두 개의 문서; 얕은 비교가 작동합니다.
			// eslint-disable-next-line eqeqeq
			if ( a == 문서 || a.ownerDocument == PreferredDoc &&
				포함(preferredDoc, a ) ) {
				-1을 반환합니다.
			}

			// 지원: IE 11+, Edge 17 - 18+
			// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
			// 두 개의 문서; 얕은 비교가 작동합니다.
			// eslint-disable-next-line eqeqeq
			if ( b == 문서 || b.ownerDocument == PreferredDoc &&
				포함(preferredDoc, b ) ) {
				1을 반환합니다.
			}

			// 원래 순서 유지
			sortInput을 반환 하시겠습니까?
				( indexOf( sortInput, a ) - indexOf( sortInput, b ) ) :
				0;
		}

		반환 비교 & 4 ? -1:1;
	} :
	함수( a, b ) {

		// 노드가 동일하면 일찍 종료
		if ( a === b ) {
			hasDuplicate = 사실;
			0을 반환합니다.
		}

		바르 커,
			나는 = 0,
			aup = a.parentNode,
			bup = b.parentNode,
			AP = [a],
			bp = [비];

		// 부모 없는 노드는 문서이거나 연결이 끊어졌습니다.
		if ( !aup || !bup ) {

			// 지원: IE 11+, Edge 17 - 18+
			// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
			// 두 개의 문서; 얕은 비교가 작동합니다.
			/* eslint-비활성화 eqeqeq */
			== 문서를 반환합니까? -1 :
				b == 문서 ? 1 :
				/* eslint 활성화 eqeqeq */
				어? -1 :
				웁? 1 :
				정렬입력?
				( indexOf( sortInput, a ) - indexOf( sortInput, b ) ) :
				0;

		// 노드가 형제이면 빠르게 확인할 수 있습니다.
		} else if ( aup === bup ) {
			return siblingCheck( a, b );
		}

		// 그렇지 않으면 비교를 위해 조상의 전체 목록이 필요합니다.
		현재 = a;
		while ( ( cur = cur.parentNode ) ) {
			ap.unshift( cur );
		}
		현재 = b;
		while ( ( cur = cur.parentNode ) ) {
			bp.unshift( 현재 );
		}

		// 불일치를 찾기 위해 트리를 따라 내려갑니다.
		while ( ap[ i ] === bp[ i ] ) {
			나++;
		}

		내가 ?

			// 노드에 공통 조상이 있는지 형제 검사를 수행합니다.
			형제 검사( ap[ i ], bp[ i ] ) :

			// 그렇지 않으면 문서의 노드가 먼저 정렬됩니다.
			// 지원: IE 11+, Edge 17 - 18+
			// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
			// 두 개의 문서; 얕은 비교가 작동합니다.
			/* eslint-비활성화 eqeqeq */
			ap[ i ] == PreferredDoc ? -1 :
			bp[ i ] == 선호Doc ? 1 :
			/* eslint 활성화 eqeqeq */
			0;
	};

	문서 반환;
};

Sizzle.matches = function( expr, elements ) {
	return Sizzle( expr, null, null, elements );
};

Sizzle.matchesSelector = function( elem, expr ) {
	setDocument( elem );

	if ( support.matchesSelector && documentIsHTML &&
		!nonnativeSelectorCache[ expr + " " ] &&
		( !rbuggyMatches || !rbuggyMatches.test( expr ) ) &&
		( !rbuggyQSA || !rbuggyQSA.test( expr ) ) ) {

		노력하다 {
			var ret = match.call( elem, expr );

			// IE 9의 matchSelector는 연결이 끊긴 노드에서 false를 반환합니다.
			if ( ret || support.disconnectedMatch ||

				// 또한 연결이 끊어진 노드는 문서에 있다고 합니다.
				// IE 9의 조각
				elem.document && elem.document.nodeType !== 11 ) {
				반환 ret;
			}
		} 잡기 ( 전자 ) {
			nonnativeSelectorCache( expr, true );
		}
	}

	return Sizzle( expr, document, null, [ elem ] ).length > 0;
};

Sizzle.contains = function( context, elem ) {

	// 필요한 경우 문서 변수를 설정합니다.
	// 지원: IE 11+, Edge 17 - 18+
	// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
	// 두 개의 문서; 얕은 비교가 작동합니다.
	// eslint-disable-next-line eqeqeq
	if ( ( context.ownerDocument || context ) != 문서 ) {
		setDocument(컨텍스트);
	}
	return contain( context, elem );
};

Sizzle.attr = function( elem, name ) {

	// 필요한 경우 문서 변수를 설정합니다.
	// 지원: IE 11+, Edge 17 - 18+
	// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
	// 두 개의 문서; 얕은 비교가 작동합니다.
	// eslint-disable-next-line eqeqeq
	if ( ( elem.ownerDocument || elem ) != 문서 ) {
		setDocument( elem );
	}

	var fn = Expr.attrHandle[ name.toLowerCase() ],

		// Object.prototype 속성에 속지 마세요(jQuery #13807)
		val = fn && hasOwn.call( Expr.attrHandle, name.toLowerCase() ) ?
			fn( 요소, 이름, !documentIsHTML ) :
			한정되지 않은;

	return val !== 정의되지 않음 ?
		발 :
		support.attributes || !문서IsHTML ?
			elem.getAttribute( 이름 ) :
			( val = elem.getAttributeNode( name ) ) && val.specified ?
				값.값:
				없는;
};

Sizzle.escape = 함수( sel ) {
	return ( sel + "" ).replace( rcssescape, fcssescape );
};

Sizzle.error = 함수( msg ) {
	throw new Error( "구문 오류, 인식할 수 없는 표현식: " + msg );
};

/**
 * 문서 정렬 및 중복 제거
 * @param {ArrayLike} 결과
 */
Sizzle.uniqueSort = 함수( 결과 ) {
	변수 요소,
		중복 = [],
		j = 0,
		나는 = 0;

	// 중복 항목을 감지할 수 있다는 것을 *알지* 않는 한, 해당 항목이 존재한다고 가정합니다.
	hasDuplicate = !support.DetectDuplicates;
	sortInput = !support.sortStable && results.slice( 0 );
	results.sort( sortOrder );

	if ( hasDuplicate ) {
		while ( ( elem = 결과[ i++ ] ) ) {
			if ( elem === 결과[ i ] ) {
				j = duplicates.push( i );
			}
		}
		동안( j-- ) {
			results.splice( 중복[ j ], 1 );
		}
	}

	// 객체를 해제하기 위해 정렬한 후 입력을 지웁니다.
	// https://github.com/jquery/sizzle/pull/225 참조
	sortInput = null;

	결과를 반환합니다.
};

/**
 * DOM 노드 배열의 텍스트 값을 검색하는 유틸리티 함수
 * @param {배열|요소} 요소
 */
getText = Sizzle.getText = 함수( elem ) {
	var 노드,
		ret = "",
		나는 = 0,
		nodeType = elem.nodeType;

	if ( !nodeType ) {

		// nodeType이 없으면 배열일 것으로 예상됩니다.
		while ( ( 노드 = elem[ i++ ] ) ) {

			// 주석 노드를 순회하지 마세요.
			ret += getText(노드);
		}
	} else if ( nodeType === 1 || nodeType === 9 || nodeType === 11 ) {

		// 요소에 textContent를 사용합니다.
		// 새 줄의 일관성을 위해 innerText 사용이 제거되었습니다(jQuery #11153).
		if ( typeof elem.textContent === "string" ) {
			elem.textContent를 반환합니다.
		} 또 다른 {

			// 자식을 순회
			for ( elem = elem.firstChild; elem; elem = elem.nextSibling ) {
				ret += getText( elem );
			}
		}
	} else if ( nodeType === 3 || nodeType === 4 ) {
		elem.nodeValue를 반환합니다.
	}

	// 주석이나 처리 명령 노드를 포함하지 마세요.

	반환 ret;
};

Expr = Sizzle.selectors = {

	//사용자가 조정할 수 있음
	캐시길이: 50,

	createPseudo: markFunction,

	일치: matchExpr,

	attr핸들: {},

	찾다: {},

	상대적인: {
		">": { 디렉토리: "parentNode", 첫 번째: true },
		" ": { 디렉토리: "parentNode" },
		"+": { dir: "previousSibling", 첫 번째: true },
		"~": { dir: "previousSibling" }
	},

	사전 필터: {
		"ATTR": 함수( 일치 ) {
			match[ 1 ] = match[ 1 ].replace( runescape, funescape );

			// 인용 여부에 관계없이 주어진 값을 match[3]으로 이동합니다.
			일치[ 3 ] = ( 일치[ 3 ] || 일치[ 4 ] ||
				일치[ 5 ] || "" ).replace( runescape, funescape );

			if ( match[ 2 ] === "~=" ) {
				일치[ 3 ] = " " + 일치[ 3 ] + " ";
			}

			return match.slice( 0, 4 );
		},

		"CHILD": 함수( 일치 ) {

			/* matchExpr["CHILD"]의 일치 항목
				1개 유형(만|n번째|...)
				2 무엇(자식|유형)
				인수 3개(짝수|홀수|\d*|\d*n([+-]\d+)?|...)
				4 xn+y 인수의 xn 구성 요소([+-]?\d*n|)
				xn 구성요소의 5개 부호
				xn 구성요소 6개
				y 성분의 7 부호
				y 성분의 8 y
			*/
			일치[ 1 ] = 일치[ 1 ].toLowerCase();

			if ( match[ 1 ].slice( 0, 3 ) === "n번째" ) {

				// n번째-*에는 인수가 필요합니다.
				if ( !match[ 3 ] ) {
					Sizzle.error( match[ 0 ] );
				}

				// Expr.filter.CHILD의 숫자 x 및 y 매개변수
				// false/true는 각각 0/1로 캐스트된다는 점을 기억하세요.
				일치[ 4 ] = +( 일치[ 4 ] ?
					일치[ 5 ] + ( 일치[ 6 ] || 1 ) :
					2 * ( match[ 3 ] === "짝수" || match[ 3 ] === "홀수" ) );
				일치[ 5 ] = +( ( 일치[ 7 ] + 일치[ 8 ] ) || 일치[ 3 ] === "이상함" );

				// 다른 유형에서는 인수를 금지합니다.
			} else if ( 일치[ 3 ] ) {
				Sizzle.error( match[ 0 ] );
			}

			반환 일치;
		},

		"의사": 함수( 일치 ) {
			var 초과,
				인용되지 않은 = !match[ 6 ] && match[ 2 ];

			if ( matchExpr[ "CHILD" ].test( match[ 0 ] ) ) {
				null을 반환;
			}

			// 인용된 인수를 있는 그대로 받아들입니다.
			if ( match[ 3 ] ) {
				일치[ 2 ] = 일치[ 4 ] || 일치[ 5 ] || "";

			// 인용되지 않은 인수에서 초과 문자를 제거합니다.
			} else if ( 인용되지 않은 && rpseudo.test( 인용되지 않은 ) &&

				// 토큰화에서 초과분 가져오기(재귀적으로)
				( 초과 = 토큰화( 인용되지 않음, true ) ) &&

				// 다음 닫는 괄호로 이동
				( 초과 = unquoted.indexOf( ")", unquoted.length - 초과 ) - unquoted.length ) ) {

				// 초과는 음수 인덱스입니다.
				match[ 0 ] = match[ 0 ].slice( 0, 초과 );
				match[ 2 ] = unquoted.slice( 0, 초과 );
			}

			// 의사 필터 메서드(유형 및 인수)에 필요한 캡처만 반환합니다.
			return match.slice( 0, 3 );
		}
	},

	필터: {

		"TAG": 함수( nodeNameSelector ) {
			var nodeName = nodeNameSelector.replace( runescape, funescape ).toLowerCase();
			return nodeNameSelector === "*" ?
				기능() {
					사실을 반환;
				} :
				함수(요소) {
					return elem.nodeName && elem.nodeName.toLowerCase() === nodeName;
				};
		},

		"클래스": 함수( 클래스이름 ) {
			var 패턴 = classCache[ className + " " ];

			반환 패턴 ||
				( 패턴 = new RegExp( "(^|" + 공백 +
					")" + className + "(" + 공백 + "|$)" ) ) && classCache(
						클래스명, 함수( elem ) {
							패턴을 반환합니다.테스트(
								typeof elem.className === "string" && elem.className ||
								typeof elem.getAttribute !== "정의되지 않음" &&
									elem.getAttribute( "class" ) ||
								""
							);
				} );
		},

		"ATTR": 함수( 이름, 연산자, 확인 ) {
			반환 함수( elem ) {
				var result = Sizzle.attr( elem, name );

				if ( 결과 == null ) {
					반환 연산자 === "!=";
				}
				if (!연산자) {
					사실을 반환;
				}

				결과 += "";

				/* eslint-disable max-len */

				반환 연산자 === "=" ? 결과 === 확인:
					연산자 === "!=" ? 결과 !== 확인:
					연산자 === "^=" ? 확인 && result.indexOf( 확인 ) === 0 :
					연산자 === "*=" ? && result.indexOf( check ) > -1 확인:
					연산자 === "$=" ? 확인 && 결과.슬라이스( -check.length ) === 확인:
					연산자 === "~=" ? ( " " + result.replace( rwhitespace, " " ) + " " ).indexOf( 확인 ) > -1 :
					연산자 === "|=" ? 결과 === 확인 || result.slice( 0, check.length + 1 ) === 확인 + "-" :
					거짓;
				/* eslint 활성화 max-len */

			};
		},

		"CHILD": 함수( 유형, 내용, _인수, 첫 번째, 마지막 ) {
			var simple = type.slice( 0, 3 ) !== "n번째",
				앞으로 = type.slice( -4 ) !== "마지막",
				ofType = 무엇 === "유형";

			첫 번째 반환 === 1 && 마지막 === 0 ?

				// :nth-*(n)에 대한 단축키
				함수(요소) {
					반환 !!elem.parentNode;
				} :

				함수( elem, _context, xml ) {
					var 캐시, UniqueCache, externalCache, 노드, nodeIndex, 시작,
						dir = 단순 !== 앞으로 ? "nextSibling": "이전 형제",
						부모 = elem.parentNode,
						이름 = ofType && elem.nodeName.toLowerCase(),
						useCache = !xml && !ofType,
						차이점 = 거짓;

					if (부모) {

						// :(첫번째|마지막|만)-(하위|유형)
						if (간단한) {
							동안 (dir) {
								노드 = 요소;
								while ( ( 노드 = 노드[ dir ] ) ) {
									if ( ofType ?
										node.nodeName.toLowerCase() === 이름:
										node.nodeType === 1 ) {

										거짓을 반환;
									}
								}

								// :only-*에 대해 반대 방향 (아직 그렇게 하지 않은 경우)
								start = dir = type === "only" && !start && "nextSibling";
							}
							사실을 반환;
						}

						시작 = [ 앞으로 ? parent.firstChild : parent.lastChild ];

						// non-xml :nth-child(...)는 `parent`에 캐시 데이터를 저장합니다.
						if ( && useCache 전달 ) {

							// 이전에 캐시된 인덱스에서 `elem`을 찾습니다.

							// ...gzip 친화적인 방식으로
							노드 = 부모;
							외부 캐시 = 노드[ 확장 ] || ( 노드[ 확장 ] = {} );

							// 지원: IE <9만 해당
							// 복제된 속성으로부터 방어합니다(jQuery gh-1709).
							UniqueCache = externalCache[ node.uniqueID ] ||
								( 외부 캐시[ node.uniqueID ] = {} );

							캐시 = UniqueCache[ 유형 ] || [];
							nodeIndex = 캐시[ 0 ] === dirruns && 캐시[ 1 ];
							diff = nodeIndex && 캐시[ 2 ];
							node = nodeIndex && parent.childNodes[ nodeIndex ];

							while ( ( 노드 = ++nodeIndex && 노드 && 노드[ dir ] ||

								// 처음부터 `elem`을 찾는 것으로 대체
								( diff = nodeIndex = 0 ) || start.pop() ) ) {

								// 발견되면 '부모'의 인덱스를 캐시하고 중단합니다.
								if ( node.nodeType === 1 && ++diff && node === elem ) {
									UniqueCache[ 유형 ] = [ dirruns, nodeIndex, diff ];
									부서지다;
								}
							}

						} 또 다른 {

							// 가능한 경우 이전에 캐시된 요소 인덱스를 사용합니다.
							if ( useCache ) {

								// ...gzip 친화적인 방식으로
								노드 = 요소;
								외부 캐시 = 노드[ 확장 ] || ( 노드[ 확장 ] = {} );

								// 지원: IE <9만 해당
								// 복제된 속성으로부터 방어합니다(jQuery gh-1709).
								UniqueCache = externalCache[ node.uniqueID ] ||
									( 외부 캐시[ node.uniqueID ] = {} );

								캐시 = UniqueCache[ 유형 ] || [];
								nodeIndex = 캐시[ 0 ] === dirruns && 캐시[ 1 ];
								diff = 노드 인덱스;
							}

							// xml :n번째-자식(...)
							// 또는 :nth-last-child(...) 또는 :nth(-last)?-of-type(...)
							if ( 차이 === false ) {

								// 위와 동일한 루프를 사용하여 처음부터 `elem`을 찾습니다.
								while ( ( 노드 = ++nodeIndex && 노드 && 노드[ dir ] ||
									( diff = nodeIndex = 0 ) || start.pop() ) ) {

									if ( ( ofType ?
										node.nodeName.toLowerCase() === 이름:
										node.nodeType === 1 ) &&
										++차이점 ) {

										// 만난 각 요소의 인덱스를 캐시합니다.
										if ( useCache ) {
											외부 캐시 = 노드[ 확장 ] ||
												( 노드[ 확장 ] = {} );

											// 지원: IE <9만 해당
											// 복제된 속성으로부터 방어합니다(jQuery gh-1709).
											UniqueCache = externalCache[ node.uniqueID ] ||
												( 외부 캐시[ node.uniqueID ] = {} );

											UniqueCache[ 유형 ] = [ dirruns, diff ];
										}

										if ( 노드 === 요소 ) {
											부서지다;
										}
									}
								}
							}
						}

						// 오프셋을 통합한 다음 주기 크기를 확인합니다.
						차이점 -= 마지막;
						diff 반환 === 먼저 || ( 차이 % 첫 번째 === 0 && 차이 / 첫 번째 >= 0 );
					}
				};
		},

		"PEUDO": 함수( 의사, 인수 ) {

			// 의사 클래스 이름은 대소문자를 구분하지 않습니다.
			// http://www.w3.org/TR/selectors/#pseudo-classes
			// 사용자 정의 의사에 대문자가 추가되는 경우 대소문자 구분에 따라 우선순위를 정합니다.
			// setFilters는 의사로부터 상속된다는 점을 기억하세요.
			변수 인수,
				fn = Expr.pseudos[ 의사 ] || Expr.setFilters[ pseudo.toLowerCase() ] ||
					Sizzle.error( "지원되지 않는 의사: " + 의사 );

			// 사용자는 createPseudo를 사용하여 다음을 나타낼 수 있습니다.
			// 필터 함수를 생성하려면 인수가 필요합니다.
			// Sizzle과 마찬가지로
			if ( fn[ 확장 ] ) {
				return fn(인수);
			}

			// 그러나 이전 서명에 대한 지원은 유지합니다.
			if ( fn.length > 1 ) {
				args = [ 의사, 의사, "", 인수 ];
				Expr.setFilters.hasOwnProperty( pseudo.toLowerCase() ) 를 반환합니까?
					markFunction( 함수( 시드, 일치 ) {
						변수 idx,
							일치 = fn( 시드, 인수 ),
							i = 일치.길이;
						동안( i-- ) {
							idx = indexOf( 시드, 일치[ i ] );
							시드[ idx ] = !( 일치[ idx ] = 일치[ i ] );
						}
					} ) :
					함수(요소) {
						return fn( elem, 0, args );
					};
			}

			fn을 반환;
		}
	},

	의사: {

		// 잠재적으로 복잡한 의사
		"not": markFunction( function( selector ) {

			// 컴파일을 위해 전달된 선택기를 다듬습니다.
			// 선행 및 후행 처리를 피하기 위해
			// 결합자로 공백
			var 입력 = [],
				결과 = [],
				matcher = compile( selector.replace( rtrim, "$1" ) );

			반환 일치자[expando]?
				markFunction( 함수( 시드, 일치, _context, xml ) {
					변수 요소,
						일치하지 않음 = 일치자(seed, null, xml, [] ),
						i = 종자.길이;

					// `matcher`와 일치하지 않는 요소를 일치시킵니다.
					동안( i-- ) {
						if ( ( elem = 일치하지 않음[ i ] ) ) {
							씨앗[ i ] = !( 일치[ i ] = elem );
						}
					}
				} ) :
				함수( elem, _context, xml ) {
					입력[ 0 ] = 요소;
					matcher(입력, null, xml, 결과);

					// 요소를 유지하지 마세요(문제 #299)
					입력[0] = 널;
					return!results.pop();
				};
		} ),

		"has": markFunction( function( selector ) {
			반환 함수( elem ) {
				return Sizzle( 선택기, elem ).length > 0;
			};
		} ),

		"포함": markFunction( function( text ) {
			text = text.replace( runescape, funescape );
			반환 함수( elem ) {
				return ( elem.textContent || getText( elem ) ).indexOf( text ) > -1;
			};
		} ),

		// "요소가 :lang() 선택기로 표현되는지 여부
		// 요소의 언어 값에만 기반합니다.
		// 식별자 C와 동일합니다.
		// 또는 식별자 C로 시작하고 바로 뒤에 "-"가 옵니다.
		// 요소의 언어 값에 대한 C의 일치는 대소문자를 구분하지 않고 수행됩니다.
		// 식별자 C는 유효한 언어 이름일 필요는 없습니다."
		// http://www.w3.org/TR/selectors/#lang-pseudo
		"lang": markFunction( 함수( lang ) {

			// lang 값은 유효한 식별자여야 합니다.
			if ( !ridentifier.test( lang || "" ) ) {
				Sizzle.error( "지원되지 않는 언어: " + lang );
			}
			lang = lang.replace( runescape, funescape ).toLowerCase();
			반환 함수( elem ) {
				var elemLang;
				하다 {
					if ( ( elemLang = documentIsHTML ?
						elem.lang :
						elem.getAttribute( "xml:lang" ) || elem.getAttribute( "lang" ) ) ) {

						elemLang = elemLang.toLowerCase();
						elemLang 반환 === lang || elemLang.indexOf( lang + "-" ) === 0;
					}
				} while ( ( elem = elem.parentNode ) && elem.nodeType === 1 );
				거짓을 반환;
			};
		} ),

		// 기타
		"대상": 함수( elem ) {
			var hash = window.location && window.location.hash;
			해시 반환 && hash.slice( 1 ) === elem.id;
		},

		"루트": 함수( elem ) {
			return elem === docElem;
		},

		"포커스": 함수( elem ) {
			return elem === document.activeElement &&
				( !document.hasFocus || document.hasFocus() ) &&
				!!( elem.type || elem.href || ~elem.tabIndex );
		},

		// 부울 속성
		"활성화됨": createDisabledPseudo( false ),
		"비활성화됨": createDisabledPseudo( true ),

		"확인됨": 함수( elem ) {

			// CSS3에서 :checked는 선택된 요소와 선택된 요소를 모두 반환해야 합니다.
			// http://www.w3.org/TR/2011/REC-css3-selectors-20110929/#checked
			var nodeName = elem.nodeName.toLowerCase();
			return ( nodeName === "input" && !!elem.checked ) ||
				( nodeName === "option" && !!elem.selected );
		},

		"선택됨": 함수( elem ) {

			// 이 속성에 액세스하면 기본적으로 선택됨이 설정됩니다.
			// Safari의 옵션이 제대로 작동합니다.
			if ( elem.parentNode ) {
				// eslint-disable-next-line 사용하지 않는 표현식
				elem.parentNode.selectedIndex;
			}

			return elem.selected === true;
		},

		// 내용물
		"비어 있음": 함수( elem ) {

			// http://www.w3.org/TR/selectors/#empty-pseudo
			// :empty는 요소(1) 또는 콘텐츠 노드(텍스트: 3; cdata: 4; 엔터티 참조: 5)에 의해 무효화됩니다.
			// 다른 사람이 아닌 경우(설명: 8; 처리 명령: 7; 등)
			// nodeType < 6은 속성(2)이 자식으로 표시되지 않기 때문에 작동합니다.
			for ( elem = elem.firstChild; elem; elem = elem.nextSibling ) {
				if ( elem.nodeType < 6 ) {
					거짓을 반환;
				}
			}
			사실을 반환;
		},

		"부모": 함수( elem ) {
			return !Expr.pseudos[ "empty" ]( elem );
		},

		// 요소/입력 유형
		"헤더": 함수( elem ) {
			return rheader.test( elem.nodeName );
		},

		"입력": 함수( elem ) {
			return rinputs.test( elem.nodeName );
		},

		"버튼": 기능( elem ) {
			var 이름 = elem.nodeName.toLowerCase();
			반환 이름 === "input" && elem.type === "button" || 이름 === "버튼";
		},

		"텍스트": 함수( elem ) {
			var 속성;
			return elem.nodeName.toLowerCase() === "입력" &&
				elem.type === "텍스트" &&

				// 지원: IE<8
				// 새로운 HTML5 속성 값(예: "search")은 elem.type === "text"와 함께 나타납니다.
				( ( attr = elem.getAttribute( "type" ) ) == null ||
					attr.toLowerCase() === "텍스트" );
		},

		// 컬렉션 내 위치
		"첫 번째": createPositionalPseudo( function() {
			반환 [ 0 ];
		} ),

		"마지막": createPositionalPseudo( function( _matchIndexes, length ) {
			반환 [ 길이 - 1 ];
		} ),

		"eq": createPositionalPseudo( function( _matchIndexes, 길이, 인수 ) {
			반환 [ 인수 < 0 ? 인수 + 길이 : 인수 ];
		} ),

		"even": createPositionalPseudo( function( matchIndexes, length ) {
			var 나는 = 0;
			for ( ; i < 길이; i += 2 ) {
				matchIndexes.push( i );
			}
			matchIndexes를 반환합니다.
		} ),

		"홀수": createPositionalPseudo( function( matchIndexes, length ) {
			var i = 1;
			for ( ; i < 길이; i += 2 ) {
				matchIndexes.push( i );
			}
			matchIndexes를 반환합니다.
		} ),

		"lt": createPositionalPseudo( function( matchIndexes, 길이, 인수 ) {
			var i = 인수 < 0?
				인수 + 길이:
				인수 > 길이 ?
					길이 :
					논쟁;
			for ( ; --i >= 0; ) {
				matchIndexes.push( i );
			}
			matchIndexes를 반환합니다.
		} ),

		"gt": createPositionalPseudo( function( matchIndexes, 길이, 인수 ) {
			var i = 인수 < 0? 인수 + 길이 : 인수;
			for ( ; ++i < 길이; ) {
				matchIndexes.push( i );
			}
			matchIndexes를 반환합니다.
		} )
	}
};

Expr.pseudos[ "nth" ] = Expr.pseudos[ "eq" ];

// 버튼/입력 유형 의사 추가
for ( i in { 라디오: true, 체크박스: true, 파일: true, 비밀번호: true, 이미지: true } ) {
	Expr.pseudos[ i ] = createInputPseudo( i );
}
for ( i in { 제출: true, 재설정: true } ) {
	Expr.pseudos[ i ] = createButtonPseudo( i );
}

// 새로운 setFilters를 생성하기 위한 쉬운 API
함수 setFilters() {}
setFilters.prototype = Expr.filters = Expr.pseudos;
Expr.setFilters = 새로운 setFilters();

tokenize = Sizzle.tokenize = function( selector,parseOnly ) {
	var 일치, 일치, 토큰, 유형,
		soFar, 그룹, 사전 필터,
		캐시됨 = tokenCache[ 선택기 + " " ];

	if(캐시됨) {
		구문 분석만 반환 ? 0 : 캐시됨.슬라이스( 0 );
	}

	지금까지 = 선택기;
	그룹 = [];
	preFilters = Expr.preFilter;

	동안(지금까지) {

		// 쉼표 및 첫 번째 실행
		if ( !matched || ( match = rcomma.exec( soFar ) ) ) {
			만약 (일치) {

				// 후행 쉼표를 유효한 것으로 사용하지 마세요.
				soFar = soFar.slice( match[ 0 ].length ) || 지금까지;
			}
			groups.push( ( 토큰 = [] ) );
		}

		일치 = 거짓;

		// 결합자
		if ( ( match = rcombinators.exec( soFar ) ) ) {
			일치 = match.shift();
			토큰.푸시({
				값: 일치,

				// 자손 연결자를 공간으로 캐스트
				유형: match[ 0 ].replace( rtrim, " " )
			} );
			soFar = soFar.slice(matched.length);
		}

		// 필터
		for ( Expr.filter에 입력 ) {
			if ( ( match = matchExpr[ 유형 ].exec( soFar ) ) && ( !preFilters[ 유형 ] ||
				( 일치 = preFilters[ 유형 ]( 일치 ) ) ) ) {
				일치 = match.shift();
				토큰.푸시({
					값: 일치,
					유형: 유형,
					일치: 일치
				} );
				soFar = soFar.slice(matched.length);
			}
		}

		if ( !matched ) {
			부서지다;
		}
	}

	// 유효하지 않은 초과 길이를 반환합니다.
	// 그냥 구문 분석하는 경우
	// 그렇지 않으면 오류를 발생시키거나 토큰을 반환합니다.
	구문 분석만 반환 ?
		soFar.length :
		지금까지 ?
			Sizzle.error( 선택기 ) :

			// 토큰을 캐시합니다.
			tokenCache( 선택기, 그룹 ).slice( 0 );
};

함수 toSelector( 토큰 ) {
	변수 i = 0,
		len = 토큰.길이,
		선택자 = "";
	for ( ; i < len; i++ ) {
		선택기 += 토큰[ i ].value;
	}
	반환 선택기;
}

함수 addCombinator( 일치자, 결합자, 기본 ) {
	var dir = Combinator.dir,
		건너뛰기 = Combinator.next,
		키 = 건너뛰기 || 디르,
		checkNonElements = 기본 && 키 === "parentNode",
		doneName = 완료++;

	return Combinator.first ?

		// 가장 가까운 조상/이전 요소를 확인합니다.
		함수(요소, 컨텍스트, xml) {
			while ( ( elem = elem[ dir ] ) ) {
				if ( elem.nodeType === 1 || checkNonElements ) {
					반환 매처( elem, context, xml );
				}
			}
			거짓을 반환;
		} :

		// 모든 조상/이전 요소를 확인합니다.
		함수(요소, 컨텍스트, xml) {
			var oldCache, UniqueCache, 외부 캐시,
				newCache = [ dirruns, doneName ];

			// XML 노드에 임의의 데이터를 설정할 수 없으므로 결합자 캐싱의 이점을 누릴 수 없습니다.
			만약 (xml) {
				while ( ( elem = elem[ dir ] ) ) {
					if ( elem.nodeType === 1 || checkNonElements ) {
						if ( matcher( elem, context, xml ) ) {
							사실을 반환;
						}
					}
				}
			} 또 다른 {
				while ( ( elem = elem[ dir ] ) ) {
					if ( elem.nodeType === 1 || checkNonElements ) {
						externalCache = elem[ 확장 ] || ( 요소[ 확장 ] = {} );

						// 지원: IE <9만 해당
						// 복제된 속성으로부터 방어합니다(jQuery gh-1709).
						UniqueCache = externalCache[ elem.uniqueID ] ||
							( 외부Cache[ elem.uniqueID ] = {} );

						if ( 건너뛰기 && 건너뛰기 === elem.nodeName.toLowerCase() ) {
							elem = elem[ dir ] || 요소;
						} else if ( ( oldCache = UniqueCache[ 키 ] ) &&
							oldCache[ 0 ] === dirruns && oldCache[ 1 ] === doneName ) {

							// 결과가 이전 요소로 역전파되도록 newCache에 할당
							return ( newCache[ 2 ] = oldCache[ 2 ] );
						} 또 다른 {

							// newcache를 재사용하여 결과가 이전 요소로 역전파되도록 합니다.
							UniqueCache[ 키 ] = newCache;

							// 일치한다는 것은 우리가 끝났음을 의미합니다. 실패는 계속 확인해야 함을 의미합니다.
							if ( ( newCache[ 2 ] = matcher( elem, context, xml ) ) ) {
								사실을 반환;
							}
						}
					}
				}
			}
			거짓을 반환;
		};
}

함수 elementMatcher(매처) {
	matchers.length > 1을 반환합니까?
		함수(요소, 컨텍스트, xml) {
			var i = matchers.length;
			동안( i-- ) {
				if ( !matchers[ i ]( elem, context, xml ) ) {
					거짓을 반환;
				}
			}
			사실을 반환;
		} :
		일치자[ 0 ];
}

function multipleContexts( 선택기, 컨텍스트, 결과 ) {
	변수 i = 0,
		len = contexts.length;
	for ( ; i < len; i++ ) {
		Sizzle( 선택자, 컨텍스트[ i ], 결과 );
	}
	결과를 반환합니다.
}

함수 응축(일치하지 않음, 맵, 필터, 컨텍스트, xml) {
	변수 요소,
		새로운 일치하지 않음 = [],
		나는 = 0,
		len = 일치하지 않는 길이,
		매핑됨 = 지도 != null;

	for ( ; i < len; i++ ) {
		if ( ( elem = 일치하지 않음[ i ] ) ) {
			if ( !filter || 필터( elem, context, xml ) ) {
				newUnmatched.push( elem );
				if (매핑됨) {
					map.push(i);
				}
			}
		}
	}

	새로운 일치하지 않는 반환;
}

함수 setMatcher( preFilter, selector, matcher, postFilter, postFinder, postSelector ) {
	if ( postFilter && !postFilter[ 확장 ] ) {
		postFilter = setMatcher( postFilter );
	}
	if ( postFinder && !postFinder[ 확장 ] ) {
		postFinder = setMatcher( postFinder, postSelector );
	}
	return markFunction( function( 시드, 결과, 컨텍스트, xml ) {
		변수 온도, i, 요소,
			사전 맵 = [],
			포스트맵 = [],
			기존 = 결과.길이,

			// 시드 또는 컨텍스트에서 초기 요소를 가져옵니다.
			elems = 씨앗 || 다중컨텍스트(
				선택기 || "*",
				context.nodeType ? [ 컨텍스트 ] : 컨텍스트,
				[]
			),

			// 일치자 입력을 얻기 위해 사전 필터를 적용하고 시드 결과 동기화를 위한 맵을 유지합니다.
			matcherIn = preFilter && ( 시드 || !selector ) ?
				응축( elems, preMap, preFilter, context, xml ) :
				요소,

			matcherOut = 일치자 ?

				// postFinder, 필터링된 시드, 시드가 아닌 postFilter 또는 기존 결과가 있는 경우,
				포스트파인더 || ( 시드 ? preFilter : 기존 || postFilter ) ?

					// ...중간 처리가 필요합니다.
					[] :

					// ...그렇지 않으면 결과를 직접 사용하세요.
					결과 :
				matcherIn;

		// 기본 일치 항목 찾기
		if (매처) {
			matcher( matcherIn, matcherOut, context, xml );
		}

		// 포스트필터 적용
		if (포스트필터) {
			온도 = 응축( matcherOut, postMap );
			postFilter( 임시, [], 컨텍스트, xml );

			// 실패한 요소를 다시 matcherIn으로 이동하여 일치를 취소합니다.
			i = 임시 길이;
			동안( i-- ) {
				if ( ( 요소 = 임시[ i ] ) ) {
					matcherOut[ postMap[ i ] ] = !( matcherIn[ postMap[ i ] ] = elem );
				}
			}
		}

		if (시드) {
			if ( postFinder || preFilter ) {
				if (포스트파인더) {

					// 이 중간체를 postFinder 컨텍스트로 압축하여 최종 matcherOut을 가져옵니다.
					온도 = [];
					i = matcherOut.length;
					동안( i-- ) {
						if ( ( elem = matcherOut[ i ] ) ) {

							// elem이 아직 최종 일치가 아니므로 matcherIn을 복원합니다.
							temp.push( ( matcherIn[ i ] = elem ) );
						}
					}
					postFinder( null, ( matcherOut = [] ), temp, xml );
				}

				// 일치하는 요소를 시드에서 결과로 이동하여 동기화를 유지합니다.
				i = matcherOut.length;
				동안( i-- ) {
					if ( ( elem = matcherOut[ i ] ) &&
						( temp = postFinder ? indexOf( seed, elem ) : preMap[ i ] ) > -1 ) {

						시드[ 온도 ] = !( 결과[ 온도 ] = elem );
					}
				}
			}

		// 정의된 경우 postFinder를 통해 결과에 요소를 추가합니다.
		} 또 다른 {
			matcherOut = 응축(
				matcherOut === 결과 ?
					matcherOut.splice( 기존, matcherOut.length ) :
					matcherOut
			);
			if (포스트파인더) {
				postFinder( null, 결과, matcherOut, xml );
			} 또 다른 {
				push.apply( 결과, matcherOut );
			}
		}
	} );
}

함수 matcherFromTokens(토큰) {
	var checkContext, 일치자, j,
		len = 토큰.길이,
		LeadingRelative = Expr.relative[ 토큰[ 0 ].type ],
		implicitRelative =leadingRelative || Expr.상대[ " " ],
		i = 선두상대적인 ? 1:0,

		// 기본 일치자는 최상위 컨텍스트에서 요소에 접근할 수 있도록 보장합니다.
		matchContext = addCombinator( function( elem ) {
			return elem === checkContext;
		}, 암시적 상대, true ),
		matchAnyContext = addCombinator( function( elem ) {
			return indexOf( checkContext, elem ) > -1;
		}, 암시적 상대, true ),
		matchers = [ function( elem, context, xml ) {
			var ret = ( !leadingRelative && ( xml || context !== externalmostContext ) ) || (
				( checkContext = 컨텍스트 ).nodeType ?
					matchContext( elem, context, xml ) :
					matchAnyContext( elem, context, xml ) );

			// 요소에 매달리는 것을 피하세요(문제 #299)
			checkContext = null;
			반환 ret;
		} ];

	for ( ; i < len; i++ ) {
		if ( ( matcher = Expr.relative[ 토큰[ i ].type ] ) ) {
			matchers = [ addCombinator( elementMatcher( matchers ), matcher ) ];
		} 또 다른 {
			matcher = Expr.filter[ 토큰[ i ].type ].apply( null, tokens[ i ].matches );

			// 위치 일치자를 보면 특수 항목을 반환합니다.
			if ( matcher[ 확장 ] ) {

				// 적절한 처리를 위해 다음 상대 연산자(있는 경우)를 찾습니다.
				j = ++i;
				for ( ; j < len; j++ ) {
					if ( Expr.relative[ 토큰[ j ].type ] ) {
						부서지다;
					}
				}
				setMatcher(를 반환합니다.
					i > 1 && elementMatcher(매처),
					i > 1 && 선택기(

					// 이전 토큰이 하위 결합자인 경우 암시적 모든 요소 `*`를 삽입합니다.
					토큰
						.슬라이스( 0, i - 1 )
						.concat( { 값: 토큰[ i - 2 ].type === " " ? "*" : "" } )
					).replace( rtrim, "$1" ),
					일치자,
					i < j && matcherFromTokens( tokens.slice( i, j ) ),
					j < len && matcherFromTokens( ( 토큰 = tokens.slice( j ) ) ),
					j < len && toSelector( 토큰 )
				);
			}
			matchers.push(매처);
		}
	}

	return elementMatcher(매처);
}

함수 matcherFromGroupMatchers( elementMatchers, setMatchers ) {
	var bySet = setMatchers.length > 0,
		byElement = elementMatchers.length > 0,
		superMatcher = 함수( 시드, 컨텍스트, xml, 결과, 가장 바깥쪽 ) {
			var 요소, j, 일치자,
				일치 개수 = 0,
				나는 = "0",
				일치하지 않음 = 시드 && [],
				setMatched = [],
				contextBackup = 가장 바깥쪽Context,

				// 항상 시드 요소나 가장 바깥쪽 컨텍스트가 있어야 합니다.
				elems = 씨앗 || byElement && Expr.find[ "TAG" ]( "*", 가장 바깥쪽 ),

				// 이것이 가장 바깥쪽 일치자인 경우 정수 dirrun을 사용합니다.
				dirrunsUnique = ( dirruns += contextBackup == null ? 1 : Math.random() || 0.1 ),
				len = elems.length;

			if (가장 바깥쪽) {

				// 지원: IE 11+, Edge 17 - 18+
				// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
				// 두 개의 문서; 얕은 비교가 작동합니다.
				// eslint-disable-next-line eqeqeq
				OutermostContext = 컨텍스트 == 문서 || 맥락 || 가장 바깥쪽;
			}

			// elementMatchers를 결과에 직접 전달하는 요소를 추가합니다.
			// 지원: IE<9, 사파리
			// ID별로 요소와 일치하는 NodeList 속성(IE: "length"; Safari: <number>)을 허용합니다.
			for ( ; i !== len && ( elem = elems[ i ] ) != null; i++ ) {
				if ( byElement && elem ) {
					j = 0;

					// 지원: IE 11+, Edge 17 - 18+
					// IE/Edge에서는 엄격하게 비교할 때 "권한 거부" 오류가 발생하는 경우가 있습니다.
					// 두 개의 문서; 얕은 비교가 작동합니다.
					// eslint-disable-next-line eqeqeq
					if ( !context && elem.ownerDocument != 문서 ) {
						setDocument( elem );
						xml = !documentIsHTML;
					}
					while ( ( matcher = elementMatchers[ j++ ] ) ) {
						if ( matcher( elem, context || document, xml ) ) {
							결과.푸시(elem);
							부서지다;
						}
					}
					if (가장 바깥쪽) {
						dirruns = dirrunsUnique;
					}
				}

				// 설정된 필터에 대해 일치하지 않는 요소를 추적합니다.
				if (bySet) {

					// 가능한 모든 일치자를 거쳤을 것입니다.
					if ( ( elem = !matcher && elem ) ) {
						matchCount--;
					}

					// 일치 여부에 관계없이 모든 요소의 배열 길이를 늘립니다.
					if (시드) {
						일치하지 않습니다.push( elem );
					}
				}
			}

			// `i`는 이제 위에서 방문한 요소의 개수이며 이를 `matchedCount`에 추가합니다.
			// 후자를 음수가 아닌 것으로 만듭니다.
			matchCount += i;

			// 일치하지 않는 요소에 설정된 필터를 적용합니다.
			// 참고: 일치하지 않는 요소가 없으면 건너뛸 수 있습니다(예: `matchedCount`
			// `i`와 같음), 위 루프에서 _모든_ 요소를 방문하지 않은 경우는 예외입니다.
			// 요소 일치자와 시드가 없습니다.
			// 초기 문자열 "0" `i`를 증가시키면 `i`가 해당 문자열에서만 문자열로 남을 수 있습니다.
			// 이 경우 `i`와 다르지만 역시 "00" `matchedCount`가 생성됩니다.
			// 수치적으로는 0입니다.
			if ( bySet && i !== matchCount ) {
				j = 0;
				while ( ( matcher = setMatchers[ j++ ] ) ) {
					matcher( 일치하지 않음, setMatched, context, xml );
				}

				if (시드) {

					// 정렬할 필요가 없도록 요소 일치를 다시 통합합니다.
					if (matchedCount > 0) {
						동안( i-- ) {
							if ( !( 일치하지 않음[ i ] || setMatched[ i ] ) ) {
								setMatched[ i ] = pop.call( 결과 );
							}
						}
					}

					// 실제 일치하는 항목만 가져오려면 인덱스 자리 표시자 값을 삭제합니다.
					setMatched = tense( setMatched );
				}

				// 결과에 일치 항목 추가
				push.apply( 결과, setMatched );

				// 여러 개의 성공적인 일치자가 연속적으로 일치하는 시드 없는 세트 일치는 정렬을 규정합니다.
				if (가장 바깥쪽 && !seed && setMatched.length > 0 &&
					(matchedCount + setMatchers.length) > 1) {

					Sizzle.uniqueSort( 결과 );
				}
			}

			// 중첩된 매처에 의한 전역 조작을 무시합니다.
			if (가장 바깥쪽) {
				dirruns = dirrunsUnique;
				OutermostContext = contextBackup;
			}

			일치하지 않는 반환;
		};

	세트로 반환 ?
		markFunction( superMatcher ) :
		슈퍼매처;
}

compile = Sizzle.compile = function( selector, match /* 내부 사용 전용 */ ) {
	내가,
		setMatchers = [],
		elementMatchers = [],
		캐시됨 = 컴파일러Cache[ 선택기 + " " ];

	if ( !cached ) {

		// 각 요소를 확인하는 데 사용할 수 있는 재귀 함수의 함수를 생성합니다.
		if ( !match ) {
			일치 = 토큰화(선택기);
		}
		i = 일치.길이;
		동안( i-- ) {
			캐시됨 = matcherFromTokens( match[ i ] );
			if ( 캐시됨[ 확장 ] ) {
				setMatchers.push(캐시됨);
			} 또 다른 {
				elementMatchers.push(캐시됨);
			}
		}

		// 컴파일된 함수를 캐시합니다.
		캐시됨 = 컴파일러캐시(
			선택자,
			matcherFromGroupMatchers( elementMatchers, setMatchers )
		);

		// 선택기와 토큰화 저장
		캐시됨.선택기 = 선택기;
	}
	캐시된 반환;
};

/**
 * Sizzle의 컴파일된 기능과 함께 작동하는 저수준 선택 기능
 * 선택기 기능
 * @param {String|Function} selector 선택기 또는 사전 컴파일된
 * Sizzle.compile로 구축된 선택기 기능
 * @param {요소} 컨텍스트
 * @param {배열} [결과]
 * @param {Array} [seed] 일치시킬 요소 집합
 */
select = Sizzle.select = function( 선택기, 컨텍스트, 결과, 시드 ) {
	var i, 토큰, 토큰, 유형, 찾기,
		컴파일됨 = 선택기 유형 === "함수" && 선택기,
		match = !seed && tokenize( ( 선택기 = 컴파일됨.선택기 || 선택기 ) );

	결과 = 결과 || [];

	// 목록에 선택기가 하나만 있고 시드가 없는 경우 작업을 최소화하려고 합니다.
	// (후자는 컨텍스트를 보장합니다)
	if ( match.length === 1 ) {

		// 선행 복합 선택기가 ID인 경우 컨텍스트를 줄입니다.
		토큰 = 일치[ 0 ] = 일치[ 0 ].slice( 0 );
		if ( tokens.length > 2 && ( 토큰 = 토큰[ 0 ] ).type === "ID" &&
			context.nodeType === 9 && documentIsHTML && Expr.relative[ 토큰[ 1 ].type ] ) {

			context = ( Expr.find[ "ID" ]( token.matches[ 0 ]
				.replace( runescape, funescape ), context ) || [] )[ 0 ];
			만약 (!컨텍스트) {
				결과를 반환합니다.

			// 미리 컴파일된 매처는 여전히 조상을 확인하므로 한 단계 올라갑니다.
			} else if (컴파일됨) {
				컨텍스트 = context.parentNode;
			}

			선택기 = selector.slice( tokens.shift().value.length );
		}

		// 오른쪽에서 왼쪽으로 일치하도록 시드 세트를 가져옵니다.
		i = matchExpr[ "needsContext" ].test( 선택기 ) ? 0 : 토큰.길이;
		동안( i-- ) {
			토큰 = 토큰[ i ];

			// 결합자에 도달하면 중단됩니다.
			if ( Expr.relative[ ( 유형 = token.type ) ] ) {
				부서지다;
			}
			if ( ( find = Expr.find[ 유형 ] ) ) {

				// 주요 형제 조합자를 검색하고 컨텍스트를 확장합니다.
				if ( ( 시드 = 찾기(
					token.matches[ 0 ].replace( runescape, funescape ),
					rsibling.test( tokens[ 0 ].type ) && testContext( context.parentNode ) ||
						문맥
				) ) ) {

					// 시드가 비어 있거나 남은 토큰이 없으면 일찍 반환할 수 있습니다.
					tokens.splice( i, 1 );
					선택기 = 시드.길이 && toSelector(토큰);
					if ( !selector ) {
						push.apply( 결과, 시드 );
						결과를 반환합니다.
					}

					부서지다;
				}
			}
		}
	}

	// 필터링 기능이 제공되지 않은 경우 필터링 기능을 컴파일하고 실행합니다.
	// 위의 선택기를 수정한 경우 재토큰화를 방지하기 위해 `match`를 제공합니다.
	( 컴파일됨 || 컴파일( 선택기, 일치 ) )(
		씨앗,
		문맥,
		!문서IsHTML,
		결과,
		!컨텍스트 || rsibling.test( 선택기 ) && testContext( context.parentNode ) || 문맥
	);
	결과를 반환합니다.
};

// 일회성 할당

// 정렬 안정성
support.sortStable = Expando.split( "" ).sort( sortOrder ).join( "" ) === Expando;

// 지원: Chrome 14-35+
// 비교 함수에 전달되지 않으면 항상 중복된 것으로 가정합니다.
support.DetectDuplicates = !!hasDuplicate;

// 기본 문서에 대해 초기화
setDocument();

// 지원: Webkit<537.32 - Safari 6.0.3/Chrome 25(Chrome 27에서 수정됨)
// 분리된 노드는 *서로* 혼란스럽게 따라옵니다.
support.sortDetached = 주장(함수(엘)) {

	// 1을 반환해야 하지만 4를 반환합니다(다음).
	return el.compareDocumentPosition( document.createElement( "fieldset" ) ) & 1;
} );

// 지원: IE<8
// 속성/속성 "보간" 방지
// https://msdn.microsoft.com/en-us/library/ms536429%28VS.85%29.aspx
if ( !assert( 함수( 엘 ) ) {
	el.innerHTML = "<a href='#'></a>";
	return el.firstChild.getAttribute( "href" ) === "#";
} ) ) {
	addHandle( "유형|href|높이|너비", function( elem, 이름, isXML ) {
		if ( !isXML ) {
			return elem.getAttribute( name, name.toLowerCase() === "type" ? 1 : 2 );
		}
	} );
}

// 지원: IE<9
// getAttribute("value") 대신 defaultValue를 사용합니다.
if ( !support.attributes || !assert( function( el ) {
	el.innerHTML = "<input/>";
	el.firstChild.setAttribute( "value", "" );
	return el.firstChild.getAttribute( "value" ) === "";
} ) ) {
	addHandle( "값", 함수( elem, _name, isXML ) {
		if ( !isXML && elem.nodeName.toLowerCase() === "입력" ) {
			elem.defaultValue를 반환합니다.
		}
	} );
}

// 지원: IE<9
// getAttribute가 거짓말인 경우 getAttributeNode를 사용하여 부울 값을 가져옵니다.
if ( !assert( 함수( 엘 ) ) {
	return el.getAttribute( "disabled" ) == null;
} ) ) {
	addHandle( booleans, function( elem, name, isXML ) {
		var 발;
		if ( !isXML ) {
			return 요소[ 이름 ] === true ? name.toLowerCase() :
				( val = elem.getAttributeNode( name ) ) && val.specified ?
					값.값:
					없는;
		}
	} );
}

Sizzle을 반환합니다.

} )( 창문 );



jQuery.find = 지글지글;
jQuery.expr = Sizzle.selectors;

// 더 이상 사용되지 않음
jQuery.expr[ ":" ] = jQuery.expr.pseudos;
jQuery.uniqueSort = jQuery.unique = Sizzle.uniqueSort;
jQuery.text = Sizzle.getText;
jQuery.isXMLDoc = Sizzle.isXML;
jQuery.contains = Sizzle.contains;
jQuery.escapeSelector = Sizzle.escape;




var dir = 함수( elem, dir,까지 ) {
	var 일치 = [],
		자르기 = !== 정의되지 않음;

	while ( ( elem = elem[ dir ] ) && elem.nodeType !== 9 ) {
		if ( elem.nodeType === 1 ) {
			if ( 잘라내기 && jQuery( elem ).is( 까지 ) ) {
				부서지다;
			}
			match.push( elem );
		}
	}
	반환 일치;
};


var 형제 = 함수(n, elem) {
	var 일치 = [];

	for ( ; n; n = n.nextSibling ) {
		if ( n.nodeType === 1 && n !== elem ) {
			match.push(n);
		}
	}

	반환 일치;
};


var rneedsContext = jQuery.expr.match.needsContext;



함수 nodeName( 요소, 이름 ) {

	return elem.nodeName && elem.nodeName.toLowerCase() === name.toLowerCase();

}
var rsingleTag = ( /^<([az][^\/\0>:\x20\t\r\n\f]*)[\x20\t\r\n\f]*\/?>( ?:<\/\1>|)$/i );



// 필터와 필터에 동일한 기능을 구현합니다.
function winnow( 요소, 한정자, not ) {
	if ( isFunction( 한정자 ) ) {
		return jQuery.grep( 요소, 함수( elem, i ) {
			return !!qualifier.call( elem, i, elem ) !== not;
		} );
	}

	// 단일 요소
	if(qualifier.nodeType) {
		return jQuery.grep( 요소, 함수( elem ) {
			return ( elem === 한정자 ) !== not;
		} );
	}

	// 요소의 배열(jQuery, 인수, 배열)
	if ( 한정자 유형 !== "string" ) {
		return jQuery.grep( 요소, 함수( elem ) {
			return ( indexOf.call( qualifier, elem ) > -1 ) !== not;
		} );
	}

	// 단순 선택자와 복잡한 선택자 모두에 대해 직접 필터링됩니다.
	return jQuery.filter( 한정자, 요소, 아님 );
}

jQuery.filter = function( expr, elems, not ) {
	var elem = 요소[ 0 ];

	만약 (아님) {
		expr = ":not(" + expr + ")";
	}

	if ( elems.length === 1 && elem.nodeType === 1 ) {
		return jQuery.find.matchesSelector( elem, expr ) ? [ 요소 ] : [];
	}

	return jQuery.find.matches( expr, jQuery.grep( elems, function( elem ) {
		return elem.nodeType === 1;
	} ) );
};

jQuery.fn.extend({
	찾기: 함수( 선택기 ) {
		var i, ret,
			len = this.length,
			자기=이것;

		if ( 선택기 유형 !== "string" ) {
			return this.pushStack( jQuery( 선택기 ).filter( function() {
				for ( i = 0; i < len; i++ ) {
					if ( jQuery.contains( self[ i ], this ) ) {
						사실을 반환;
					}
				}
			} ) );
		}

		ret = this.pushStack( [] );

		for ( i = 0; i < len; i++ ) {
			jQuery.find( 선택자, self[ i ], ret );
		}

		len > 1을 반환합니까? jQuery.uniqueSort(ret) : ret;
	},
	필터: 함수( 선택기 ) {
		return this.pushStack( winnow( this, selector || [], false ) );
	},
	아님: 함수( 선택기 ) {
		return this.pushStack( winnow( this, selector || [], true ) );
	},
	is: 함수( 선택기 ) {
		반환 !!winnow(
			이것,

			// 위치/상대 선택자인 경우 반환된 세트의 멤버쉽을 확인합니다.
			// 따라서 $("p:first").is("p:last")는 두 개의 "p"가 있는 문서에 대해 true를 반환하지 않습니다.
			typeof selector === "string" && rneedsContext.test( selector ) ?
				jQuery(선택기):
				선택기 || [],
			거짓
		).길이;
	}
} );


// jQuery 객체 초기화


// 루트 jQuery(문서)에 대한 중앙 참조
var 루트jQuery,

	// HTML 문자열을 확인하는 간단한 방법
	// location.hash를 통한 XSS를 방지하려면 <tag>보다 #id를 우선시하세요(#9521).
	// 엄격한 HTML 인식(#11290: <으로 시작해야 함)
	// 속도를 위한 간단한 #id 케이스 바로가기
	rquickExpr = /^(?:\s*(<[\w\W]+>)[^>]*|#([\w-]+))$/,

	init = jQuery.fn.init = function( 선택기, 컨텍스트, 루트 ) {
		var 일치, 요소;

		// 처리: $(""), $(null), $(정의되지 않음), $(false)
		if ( !selector ) {
			이거 돌려줘;
		}

		// init() 메소드는 대체 rootjQuery를 허용합니다.
		// 마이그레이션이 jQuery.sub를 지원할 수 있도록 (gh-2101)
		루트 = 루트 || 루트jQuery;

		// HTML 문자열 처리
		if ( 선택기 유형 === "문자열" ) {
			if ( 선택기[ 0 ] === "<" &&
				선택기[ selector.length - 1 ] === ">" &&
				selector.length >= 3 ) {

				// <>로 시작하고 끝나는 문자열은 HTML이라고 가정하고 정규식 검사를 건너뜁니다.
				match = [ null, 선택기, null ];

			} 또 다른 {
				match = rquickExpr.exec(선택기);
			}

			// html과 일치하거나 #id에 대해 컨텍스트가 지정되지 않았는지 확인하세요.
			if ( match && ( match[ 1 ] || !context ) ) {

				// 처리: $(html) -> $(배열)
				if ( match[ 1 ] ) {
					context = jQuery의 컨텍스트 인스턴스 ? 컨텍스트[ 0 ] : 컨텍스트;

					// 스크립트를 실행하는 옵션은 이전 버전과 호환되는 경우 true입니다.
					//parseHTML이 존재하지 않는 경우 의도적으로 오류가 발생하도록 허용합니다.
					jQuery.merge( 이, jQuery.parseHTML(
						일치[ 1 ],
						컨텍스트 && context.nodeType ? context.ownerDocument || 컨텍스트: 문서,
						진실
					) );

					// 핸들: $(html, props)
					if ( rsingleTag.test( match[ 1 ] ) && jQuery.isPlainObject( context ) ) {
						for(문맥상 일치) {

							// 가능하다면 컨텍스트의 속성을 메소드로 호출합니다.
							if ( isFunction( this[ match ] ) ) {
								this[ 일치 ]( 컨텍스트[ 일치 ] );

							// ...그렇지 않으면 속성으로 설정됩니다.
							} 또 다른 {
								this.attr( match, context[ match ] );
							}
						}
					}

					이거 돌려줘;

				// 처리: $(#id)
				} 또 다른 {
					elem = document.getElementById( match[ 2 ] );

					if ( 요소 ) {

						// jQuery 객체에 요소를 직접 삽입합니다.
						this[ 0 ] = 요소;
						this.length = 1;
					}
					이거 돌려줘;
				}

			// 처리: $(expr, $(...))
			} else if ( !context || context.jquery ) {
				return(컨텍스트 || 루트).find(선택기);

			// 처리: $(expr, 컨텍스트)
			// (다음과 같습니다: $(context).find(expr)
			} 또 다른 {
				return this.constructor(컨텍스트).find(선택기);
			}

		// 핸들: $(DOMElement)
		} else if ( selector.nodeType ) {
			this[ 0 ] = 선택자;
			this.length = 1;
			이거 돌려줘;

		// 처리: $(함수)
		// 문서 준비 단축키
		} else if ( isFunction( 선택기 ) ) {
			return root.ready !== 정의되지 않음 ?
				root.ready( 선택기 ) :

				//Ready가 없으면 즉시 실행
				선택기(jQuery);
		}

		return jQuery.makeArray( 선택자, this );
	};

// 나중에 인스턴스화할 수 있도록 초기화 함수에 jQuery 프로토타입을 제공합니다.
init.prototype = jQuery.fn;

// 중앙 참조 초기화
rootjQuery = jQuery(문서);


var rparentsprev = /^(?:parents|prev(?:Until|All))/,

	// 고유한 집합에서 시작할 때 고유한 집합을 생성하는 것이 보장되는 메서드
	보장된 고유 = {
		아이들: 맞아요,
		내용: 사실,
		다음: 사실,
		이전: 사실
	};

jQuery.fn.extend({
	있음: 함수( 대상 ) {
		var 타겟 = jQuery( 타겟, this ),
			l = 목표.길이;

		return this.filter( function() {
			var 나는 = 0;
			for ( ; i < l; i++ ) {
				if ( jQuery.contains( this,targets[ i ] ) ) {
					사실을 반환;
				}
			}
		} );
	},

	가장 가까운: 함수(선택자, 컨텍스트) {
		바르 커,
			나는 = 0,
			l = this.length,
			일치 = [],
			target = 선택기 유형 !== "string" && jQuery( 선택기 );

		// _selection_ 컨텍스트가 없기 때문에 위치 선택자는 절대 일치하지 않습니다.
		if ( !rneedsContext.test( 선택기 ) ) {
			for ( ; i < l; i++ ) {
				for ( cur = this[ i ]; cur && cur !== context; cur = cur.parentNode ) {

					// 항상 문서 조각을 건너뜁니다.
					if ( cur.nodeType < 11 && ( 목표 ?
						target.index( cur ) > -1 :

						// 요소가 아닌 항목을 Sizzle에 전달하지 마세요.
						cur.nodeType === 1 &&
							jQuery.find.matchesSelector( cur, 선택기 ) ) ) {

						match.push( cur );
						부서지다;
					}
				}
			}
		}

		return this.pushStack( match.length > 1 ? jQuery.uniqueSort( match ) : match );
	},

	// 세트 내 요소의 위치를 ​​결정합니다.
	인덱스: 함수( elem ) {

		// 인수가 없습니다. 부모의 인덱스를 반환합니다.
		if ( !elem ) {
			return ( this[ 0 ] && this[ 0 ].parentNode ) ? this.first().prevAll().length : -1;
		}

		// 선택기의 인덱스
		if ( 요소 유형 === "문자열" ) {
			return indexOf.call( jQuery( elem ), this[ 0 ] );
		}

		// 원하는 요소의 위치를 ​​찾습니다.
		indexOf.call( this,

			// jQuery 객체를 받으면 첫 번째 요소가 사용됩니다.
			elem.jquery? 요소[ 0 ] : 요소
		);
	},

	추가: 함수( 선택기, 컨텍스트 ) {
		this.pushStack을 반환합니다(
			jQuery.uniqueSort(
				jQuery.merge( this.get(), jQuery( 선택기, 컨텍스트 ) )
			)
		);
	},

	addBack: 함수( 선택기 ) {
		return this.add( 선택기 == null ?
			this.prevObject : this.prevObject.filter( 선택자 )
		);
	}
} );

함수 형제( cur, dir ) {
	while ( ( cur = cur[ dir ] ) && cur.nodeType !== 1 ) {}
	현재 반환;
}

jQuery.each({
	상위: 함수( elem ) {
		var parent = elem.parentNode;
		부모 반환 && parent.nodeType !== 11 ? 부모 : null;
	},
	부모: 함수( elem ) {
		return dir( elem, "parentNode" );
	},
	parentUntil: 함수( elem, _i,까지 ) {
		return dir( elem, "parentNode", Until );
	},
	다음: 함수( elem ) {
		return sibling( elem, "nextSibling" );
	},
	이전: 함수( elem ) {
		return sibling( elem, "previousSibling" );
	},
	nextAll: 함수( elem ) {
		return dir( elem, "nextSibling" );
	},
	prevAll: 함수( 요소 ) {
		return dir( elem, "previousSibling" );
	},
	nextUntil: 함수( elem, _i,까지 ) {
		return dir( elem, "nextSibling", Until );
	},
	prevUntil: 함수( elem, _i, Until ) {
		return dir( elem, "previousSibling", Until );
	},
	형제자매: 함수( elem ) {
		return siblings( ( elem.parentNode || {} ).firstChild, elem );
	},
	어린이: 함수( elem ) {
		형제자매 반환( elem.firstChild );
	},
	내용: 함수( elem ) {
		if ( elem.contentDocument != null &&

			// 지원: IE 11+
			// `data` 속성이 없는 <object> 요소에는 객체가 있습니다.
			// `null` 프로토타입이 있는 `contentDocument`.
			getProto( elem.contentDocument ) ) {

			elem.contentDocument를 반환합니다.
		}

		// 지원: IE 9 - 11만 해당, iOS 7만 해당, Android 브라우저 <=4.3만 해당
		// 템플릿 요소를 브라우저에서 일반 요소로 처리합니다.
		// 지원하지 않습니다.
		if ( nodeName( elem, "템플릿" ) ) {
			elem = elem.content || 요소;
		}

		return jQuery.merge( [], elem.childNodes );
	}
}, 함수( 이름, fn ) {
	jQuery.fn[ 이름 ] = 함수( 까지, 선택기 ) {
		var match = jQuery.map( this, fn, Until );

		if ( name.slice( -5 ) !== "Until" ) {
			선택자 = ~까지;
		}

		if ( 선택기 && 유형선택기 === "문자열" ) {
			match = jQuery.filter( 선택기, 일치 );
		}

		if ( this.length > 1 ) {

			// 중복 제거
			if ( !guaranteedUnique[ 이름 ] ) {
				jQuery.uniqueSort( 일치 );
			}

			// 상위* 및 이전 파생상품의 역순
			if ( rparentsprev.test( 이름 ) ) {
				match.reverse();
			}
		}

		return this.pushStack(일치);
	};
} );
var rnothtmlwhite = ( /[^\x20\t\r\n\f]+/g );



// 문자열 형식의 옵션을 객체 형식의 옵션으로 변환합니다.
함수 createOptions(옵션) {
	var 객체 = {};
	jQuery.each( options.match( rnothtmlwhite ) || [], function( _, flag ) {
		객체[플래그] = true;
	} );
	반환 개체;
}

/*
 * 다음 매개변수를 사용하여 콜백 목록을 생성합니다.
 *
 * 옵션: 방법을 변경하는 공백으로 구분된 옵션의 선택적 목록입니다.
 * 콜백 목록이 동작하거나 보다 전통적인 옵션 개체
 *
 * 기본적으로 콜백 목록은 이벤트 콜백 목록처럼 작동하며
 * 여러 번 "해고"되었습니다.
 *
 * 가능한 옵션:
 *
 * 한 번: 콜백 목록이 한 번만 실행되도록 보장합니다(예: Deferred).
 *
 * 메모리: 이전 값을 추적하고 추가된 콜백을 호출합니다.
 * 최신 "기억된" 항목으로 목록이 바로 실행된 후
 * 값(예: Deferred)
 *
 * 고유: 콜백을 한 번만 추가할 수 있도록 합니다(목록에 중복 없음).
 *
 * stopOnFalse: 콜백이 false를 반환할 때 호출을 중단합니다.
 *
 */
jQuery.Callbacks = 함수(옵션) {

	// 필요한 경우 문자열 형식에서 개체 형식으로 옵션을 변환합니다.
	// (캐시를 먼저 체크인합니다)
	옵션 = 옵션 유형 === "문자열" ?
		createOptions( 옵션 ) :
		jQuery.extend({}, 옵션);

	var // 목록이 현재 실행 중인지 여부를 알려주는 플래그
		발사,

		// 잊을 수 없는 목록의 마지막 실행 값
		메모리,

		// 목록이 이미 실행되었는지 여부를 알려주는 플래그
		해고,

		// 실행을 방지하기 위한 플래그
		잠김,

		// 실제 콜백 목록
		목록 = [],

		// 반복 가능한 목록에 대한 실행 데이터 큐
		대기열 = [],

		// 현재 실행 중인 콜백의 인덱스(필요에 따라 추가/제거로 수정됨)
		발사 지수 = -1,

		// 콜백 실행
		불 = 함수() {

			// 단일 실행 실행
			잠김 = 잠김 || 옵션.한 번;

			// 보류 중인 모든 실행에 대해 콜백을 실행합니다.
			// FireIndex 재정의 및 런타임 변경 사항 준수
			발사 = 발사 = 사실;
			for ( ; queue.length; FireIndex = -1 ) {
				메모리 = queue.shift();
				while ( ++fireingIndex < list.length ) {

					// 콜백을 실행하고 조기 종료를 확인합니다.
					if ( 목록[ FireIndex ].apply( 메모리[ 0 ], 메모리[ 1 ] ) === false &&
						options.stopOnFalse ) {

						// 끝으로 이동하고 .add가 다시 실행되지 않도록 데이터를 잊어버립니다.
						FireIndex = list.length;
						기억 = 거짓;
					}
				}
			}

			// 작업이 끝나면 데이터를 잊어버립니다.
			if ( !options.memory ) {
				기억 = 거짓;
			}

			발사 = 거짓;

			// 실행이 완료되면 정리합니다.
			if (잠김) {

				// 향후 추가 호출을 위한 데이터가 있으면 빈 목록을 유지합니다.
				if (메모리) {
					목록 = [];

				// 그렇지 않으면 이 객체는 소비됩니다.
				} 또 다른 {
					목록 = "";
				}
			}
		},

		// 실제 콜백 객체
		자기 = {

			// 목록에 콜백 또는 콜백 모음을 추가합니다.
			추가: 함수() {
				if (목록) {

					// 과거 실행의 메모리가 있으면 추가한 후 실행해야 합니다.
					if ( 메모리 && !firing ) {
						FireIndex = list.length - 1;
						queue.push(메모리);
					}

					( 함수 추가( 인수 ) {
						jQuery.each( args, 함수( _, arg ) {
							if ( isFunction( 인수 ) ) {
								if ( !options.unique || !self.has( arg ) ) {
									목록.푸시(arg);
								}
							} else if ( arg && arg.length && toType( arg ) !== "string" ) {

								// 재귀적으로 검사
								추가(인수);
							}
						} );
					} )( 인수 );

					if ( 메모리 && !firing ) {
						불();
					}
				}
				이거 돌려줘;
			},

			// 목록에서 콜백을 제거합니다.
			제거: 함수() {
				jQuery.each( 인수, 함수( _, arg ) {
					변수 인덱스;
					while ( ( index = jQuery.inArray( arg, list, index ) ) > -1 ) {
						list.splice( index, 1 );

						// 실행 인덱스 처리
						if ( 인덱스 <= FireIndex ) {
							발사지수--;
						}
					}
				} );
				이거 돌려줘;
			},

			// 주어진 콜백이 목록에 있는지 확인합니다.
			// 인수가 주어지지 않으면 목록에 콜백이 첨부되어 있는지 여부를 반환합니다.
			있음: 함수( fn ) {
				fn을 반환 ?
					jQuery.inArray( fn, list ) > -1 :
					목록.길이 > 0;
			},

			// 목록에서 모든 콜백을 제거합니다.
			비어 있음: 함수() {
				if (목록) {
					목록 = [];
				}
				이거 돌려줘;
			},

			// .fire 및 .add 비활성화
			// 현재/보류 중인 실행을 중단합니다.
			// 모든 콜백과 값을 지웁니다.
			비활성화: 함수() {
				잠김 = 대기열 = [];
				목록 = 메모리 = "";
				이거 돌려줘;
			},
			비활성화됨: 기능() {
				반환! 목록;
			},

			// .fire 비활성화
			// 메모리가 없으면 .add도 비활성화합니다(효과가 없으므로).
			// 보류 중인 실행을 중단합니다.
			잠금: 함수() {
				잠김 = 대기열 = [];
				if ( !memory && !fireing ) {
					목록 = 메모리 = "";
				}
				이거 돌려줘;
			},
			잠김: 함수() {
				반환 !!잠김;
			},

			// 주어진 컨텍스트와 인수를 사용하여 모든 콜백을 호출합니다.
			fireWith: 함수(컨텍스트, 인수) {
				if ( !locked ) {
					args = args || [];
					args = [ 컨텍스트, args.slice ? args.slice() : args ];
					queue.push(args);
					if ( !fireing ) {
						불();
					}
				}
				이거 돌려줘;
			},

			// 주어진 인수로 모든 콜백을 호출합니다.
			불: 함수() {
				self.fireWith( this, 인수 );
				이거 돌려줘;
			},

			// 콜백이 이미 한 번 이상 호출되었는지 확인하기 위해
			해고됨: function() {
				반환 !!해고;
			}
		};

	자기를 돌려보내라;
};


함수 항등( v ) {
	v를 반환;
}
함수 투척자( ex ) {
	예를 던져;
}

함수 acceptValue( 값, 해결, 거부, noValue ) {
	var 메소드;

	노력하다 {

		// 동기 동작에 대한 권한을 부여하려면 약속 측면을 먼저 확인하세요.
		if ( value && isFunction( ( method = value.promise ) ) ) {
			method.call( 값 ).done( 해결 ).fail( 거부 );

		// 기타 thenables
		} else if ( value && isFunction( ( 메소드 = value.then ) ) ) {
			method.call(값, 해결, 거부);

		// 기타 non-thenable
		} 또 다른 {

			// Array#slice가 부울 `noValue`를 정수로 변환하도록 하여 `resolve` 인수를 제어합니다.
			// * false: [ 값 ].slice( 0 ) => 해결( 값 )
			// * true: [ 값 ].slice( 1 ) => 해결()
			해결.적용( 정의되지 않음, [ 값 ].slice( noValue ) );
		}

	// Promises/A+의 경우 예외를 거부로 변환합니다.
	// jQuery.when은 thenable을 풀지 않으므로 다음에 나타나는 추가 검사를 건너뛸 수 있습니다.
	// Deferred#then은 조건부로 거부를 억제합니다.
	} 캐치(값) {

		// 지원: Android 4.0 전용
		// .call/.apply 없이 호출된 엄격 모드 함수는 전역 객체 컨텍스트를 얻습니다.
		거부.적용( 정의되지 않음, [ 값 ] );
	}
}

jQuery.확장({

	지연됨: 함수( func ) {
		var 튜플 = [

				// 액션, 리스너 추가, 콜백,
				// ... .then 핸들러, 인수 인덱스, [최종 상태]
				[ "알림", "진행", jQuery.Callbacks( "메모리" ),
					jQuery.Callbacks( "메모리" ), 2 ],
				[ "해결", "완료", jQuery.Callbacks( "한 번 메모리" ),
					jQuery.Callbacks( "한 번 메모리" ), 0, "해결됨" ],
				[ "거부", "실패", jQuery.Callbacks( "한 번 메모리" ),
					jQuery.Callbacks( "한 번 메모리" ), 1, "거부됨" ]
			],
			상태 = "보류 중",
			약속 = {
				상태: 함수() {
					반환 상태;
				},
				항상: 함수() {
					deferred.done(인수).fail(인수);
					이거 돌려줘;
				},
				"catch": 함수( fn ) {
					return promise.then( null, fn );
				},

				// 하위호환을 위해 파이프 유지
				파이프: 함수( /* fnDone, fnFail, fnProgress */ ) {
					var fns = 인수;

					return jQuery.Deferred( 함수( newDefer ) {
						jQuery.each( 튜플, 함수( _i, tuple ) {

							// 튜플(진행, 완료, 실패)을 인수(완료, 실패, 진행)에 매핑합니다.
							var fn = isFunction( fns[ tuple[ 4 ] ] ) && fns[ tuple[ 4 ] ];

							// deferred.progress(function() { newDefer 또는 newDefer.notify에 바인딩 })
							// deferred.done(function() { newDefer 또는 newDefer.resolve에 바인딩 })
							// deferred.fail(function() { newDefer 또는 newDefer.reject에 바인딩 })
							지연된[ 튜플[ 1 ] ]( 함수() {
								var return = fn && fn.apply( this, 인수 );
								if ( 반환된 && isFunction( 반환됨.promise ) ) {
									반환.약속()
										.progress( newDefer.notify )
										.done( newDefer.resolve )
										.fail( newDefer.reject );
								} 또 다른 {
									newDefer[ tuple[ 0 ] + "함께" ](
										이것,
										fn? [ 반환됨 ] : 인수
									);
								}
							} );
						} );
						fns = 널;
					} ).약속하다();
				},
				그런 다음: 함수( onFulfilled, onRejected, onProgress ) {
					var 최대 깊이 = 0;
					함수 해결(깊이, 지연, 핸들러, 특수) {
						반환 함수() {
							var that = this,
								args = 인수,
								mightThrow = 함수() {
									그러면 var가 반환되었습니다.

									// 지원: Promises/A+ 섹션 2.3.3.3.3
									// https://promisesaplus.com/#point-59
									// 이중 해결 시도를 무시합니다.
									if (깊이 < 최대 깊이) {
										반품;
									}

									반환됨 = handler.apply(that, args);

									// 지원: Promises/A+ 섹션 2.3.1
									// https://promisesaplus.com/#point-48
									if ( 반환 === deferred.promise() ) {
										throw new TypeError( "Thenable self-solution" );
									}

									// 지원: Promises/A+ 섹션 2.3.3.1, 3.5
									// https://promisesaplus.com/#point-54
									// https://promisesaplus.com/#point-75
									// `then`을 한 번만 검색합니다.
									그런 다음 = 반환 &&

										// 지원: Promises/A+ 섹션 2.3.4
										// https://promisesaplus.com/#point-64
										// 객체와 함수의 그때 가능성만 확인합니다.
										( 반환된 유형 === "객체" ||
											반환된 유형 === "함수" ) &&
										돌아왔다.그러면;

									// 반환된 thenable을 처리합니다.
									if ( isFunction( then ) ) {

										// 특수 프로세서(통지)는 해결을 기다립니다.
										if (특수) {
											then.call(
												반환,
												해결( maxDepth, deferred, Identity, 특수 ),
												해결( maxDepth, deferred, Thrower, 특수 )
											);

										// 일반 프로세서(해결)도 진행에 연결됩니다.
										} 또 다른 {

											// ...그리고 이전 해상도 값은 무시합니다.
											최대깊이++;

											then.call(
												반환,
												해결( maxDepth, deferred, Identity, 특수 ),
												해결( maxDepth, deferred, Thrower, 특수 ),
												해결(maxDepth, deferred, Identity,
													deferred.notifyWith )
											);
										}

									// 다른 모든 반환 값을 처리합니다.
									} 또 다른 {

										// 대체 핸들러만 컨텍스트를 전달합니다.
										// 및 여러 값(비사양 동작)
										if ( 핸들러 !== ID ) {
											= 정의되지 않음;
											args = [반환됨];
										}

										// 값을 처리합니다.
										// 기본 프로세스는 해결입니다.
										( 특수 || deferred.resolveWith )( that, args );
									}
								},

								// 일반 프로세서만(해결) 예외를 포착하고 거부합니다.
								프로세스 = 특별 ?
									던질 수도 있다:
									기능() {
										노력하다 {
											힘던지기();
										} 잡기 ( 전자 ) {

											if ( jQuery.Deferred.ExceptionHook ) {
												jQuery.Deferred.ExceptionHook(e,
													process.stackTrace );
											}

											// 지원: Promises/A+ 섹션 2.3.3.3.4.1
											// https://promisesaplus.com/#point-61
											// 해결 후 예외를 무시합니다.
											if (깊이 + 1 >= 최대 깊이) {

												// 대체 핸들러만 컨텍스트를 전달합니다.
												// 및 여러 값(비사양 동작)
												if ( 핸들러 !== 투척자 ) {
													= 정의되지 않음;
													args = [ 전자 ];
												}

												deferred.rejectWith(that, args);
											}
										}
									};

							// 지원: Promises/A+ 섹션 2.3.3.3.1
							// https://promisesaplus.com/#point-57
							// 잘못된 거부를 피하기 위해 약속을 즉시 다시 해결합니다.
							// 후속 오류
							if (깊이) {
								프로세스();
							} 또 다른 {

								// 예외 발생 시 스택을 기록하기 위해 선택적 후크를 호출합니다.
								// 실행이 비동기화되면 손실되기 때문입니다.
								if ( jQuery.Deferred.getStackHook ) {
									process.stackTrace = jQuery.Deferred.getStackHook();
								}
								window.setTimeout(프로세스);
							}
						};
					}

					return jQuery.Deferred( 함수( newDefer ) {

						// Progress_handlers.add( ... )
						튜플[ 0 ][ 3 ].add(
							해결하다(
								0,
								새로운 연기,
								isFunction( onProgress ) ?
									진행 중 :
									신원,
								newDefer.notifyWith
							)
						);

						//fulfilled_handlers.add( ... )
						튜플[ 1 ][ 3 ].add(
							해결하다(
								0,
								새로운 연기,
								isFunction( onFulfilled ) ?
									이행 완료 :
									신원
							)
						);

						// 거부된_handlers.add( ... )
						튜플[ 2 ][ 3 ].add(
							해결하다(
								0,
								새로운 연기,
								isFunction( onRejected ) ?
									거부됨:
									던지는 사람
							)
						);
					} ).약속하다();
				},

				// 연기된 것에 대한 약속을 얻습니다.
				// obj가 제공되면 Promise 측면이 객체에 추가됩니다.
				약속: 함수( obj ) {
					return obj != null ? jQuery.extend( obj, promise ) : 약속;
				}
			},
			연기됨 = {};

		// 목록별 메소드 추가
		jQuery.each( 튜플, 함수( i, tuple ) {
			var 목록 = 튜플[ 2 ],
				stateString = 튜플[ 5 ];

			// 약속.진행 = 목록.추가
			// 약속.완료 = 목록.추가
			// 약속.실패 = 목록.추가
			약속[ tuple[ 1 ] ] = list.add;

			// 상태 처리
			if ( stateString ) {
				목록.추가(
					기능() {

						// 상태 = "해결됨"(즉, 충족됨)
						// 상태 = "거부됨"
						상태 = 상태문자열;
					},

					// 거부된_callbacks.disable
					//fulfilled_callbacks.disable
					튜플[ 3 - i ][ 2 ].disable,

					// 거부된_handlers.disable
					//fulfilled_handlers.disable
					튜플[ 3 - i ][ 3 ].disable,

					// Progress_callbacks.lock
					튜플[ 0 ][ 2 ].lock,

					// Progress_handlers.lock
					튜플[ 0 ][ 3 ].lock
				);
			}

			// Progress_handlers.fire
			//fulfilled_handlers.fire
			// 거부된_handlers.fire
			list.add( tuple[ 3 ].fire );

			// deferred.notify = function() { deferred.notifyWith(...) }
			// deferred.resolve = function() { deferred.resolveWith(...) }
			// deferred.reject = function() { deferred.rejectWith(...) }
			지연된[ 튜플[ 0 ] ] = 함수() {
				deferred[ tuple[ 0 ] + "With" ]( this === deferred ? 정의되지 않음 : this, 인수 );
				이거 돌려줘;
			};

			// deferred.notifyWith = list.fireWith
			// deferred.resolveWith = list.fireWith
			// deferred.rejectWith = list.fireWith
			deferred[ tuple[ 0 ] + "With" ] = list.fireWith;
		} );

		// 연기된 것을 약속으로 만듭니다.
		promise.promise( 연기됨 );

		// 주어진 func를 호출합니다.
		if (펑크) {
			func.call( 연기됨, 연기됨 );
		}

		// 모두 완료되었습니다!
		반품 연기됨;
	},

	// 지연된 도우미
	언제: 함수( 단일값 ) {
		var

			// 완료되지 않은 하위 항목 수
			남은 = 인수.길이,

			// 처리되지 않은 인수 수
			나 = 남음,

			// 하위 이행 데이터
			ResolveContexts = 배열( i ),
			해결값 = 슬라이스.콜(인수),

			// 기본 지연
			기본 = jQuery.Deferred(),

			// 하위 콜백 팩토리
			updateFunc = 함수( i ) {
				반환 함수(값) {
					resolveContexts[ i ] = this;
					해결값[ i ] = 인수.길이 > 1 ? Slice.call( 인수 ) : 값;
					if ( !( --remaining ) ) {
						primary.resolveWith(resolveContexts,resolveValues);
					}
				};
			};

		// Promise.resolve처럼 단일 및 빈 인수가 채택됩니다.
		if (남은 <= 1) {
			adoptValue(singleValue,primary.done(updateFunc(i)).resolve,primary.reject,
				!나머지 );

			// 보조 Thenable을 풀려면 .then()을 사용하세요(cf. gh-3000).
			if (primary.state() === "보류 중" ||
				isFunction( 해결값[ i ] && 해결값[ i ].then ) ) {

				기본.then()을 반환합니다.
			}
		}

		// 여러 인수는 Promise.all 배열 요소처럼 집계됩니다.
		동안( i-- ) {
			채택값( 해결값[ i ], updateFunc( i ), Primary.reject );
		}

		기본.약속()을 반환합니다.
	}
} );


// 이는 일반적으로 개발 중 프로그래머의 실수를 나타냅니다.
// 기본적으로 삼키기보다는 최대한 빨리 경고합니다.
var rerrorNames = /^(Eval|Internal|Range|Reference|Syntax|Type|URI)Error$/;

jQuery.Deferred.ExceptionHook = 함수( 오류, 스택 ) {

	// 지원: IE 8 - 9만 해당
	// 개발 도구가 열려 있을 때 콘솔이 존재하며 이는 언제든지 발생할 수 있습니다.
	if ( window.console && window.console.warn && error && rerrorNames.test( error.name ) ) {
		window.console.warn( "jQuery.Deferred 예외: " + error.message, error.stack, stack );
	}
};




jQuery.readyException = 함수( 오류 ) {
	window.setTimeout(함수() {
		오류 발생;
	} );
};




// DOM 준비에 사용되는 지연
var ReadyList = jQuery.Deferred();

jQuery.fn.ready = 함수(fn) {

	준비 목록
		.그러면(fn)

		// 조회가 가능하도록 jQuery.readyException을 함수에 래핑합니다.
		// 콜백 대신 오류 처리 시 발생
		// 등록.
		.catch( 함수( 오류 ) {
			jQuery.readyException( 오류 );
		} );

	이거 돌려줘;
};

jQuery.확장({

	// DOM을 사용할 준비가 되었나요? 발생하면 true로 설정됩니다.
	준비됨: 거짓,

	// 이전에 기다려야 할 항목 수를 추적하는 카운터
	// 준비 이벤트가 발생합니다. #6781 참조
	준비대기: 1,

	// DOM이 준비되면 처리합니다.
	준비: 함수( 잠깐 ) {

		// 보류 중인 보류가 있거나 이미 준비가 된 경우 중단합니다.
		if ( wait === true ? --jQuery.readyWait : jQuery.isReady ) {
			반품;
		}

		// DOM이 준비되었음을 기억하세요
		jQuery.isReady = true;

		// 일반적인 DOM 준비 이벤트가 발생하면 감소하고 필요한 경우 기다립니다.
		if ( 대기 !== true && --jQuery.readyWait > 0 ) {
			반품;
		}

		//바인딩된 함수가 있으면 실행
		ReadyList.resolveWith( document, [ jQuery ] );
	}
} );

jQuery.ready.then = ReadyList.then;

// 준비 이벤트 핸들러 및 자체 정리 방법
함수 완료() {
	document.removeEventListener( "DOMContentLoaded", Completed );
	window.removeEventListener( "load", Completed );
	jQuery.ready();
}

// $(document).ready()가 호출되는 경우를 포착합니다.
// 브라우저 이벤트가 이미 발생한 후.
// 지원: IE <=9 - 10만
// 이전 IE에서는 "대화형" 신호를 너무 빨리 보내는 경우가 있습니다.
if ( document.readyState === "완료" ||
	( document.readyState !== "로드 중" && !document.documentElement.doScroll ) ) {

	// 스크립트가 준비를 지연할 수 있도록 비동기적으로 처리합니다.
	window.setTimeout(jQuery.ready);

} 또 다른 {

	// 편리한 이벤트 콜백 사용
	document.addEventListener( "DOMContentLoaded", Completed );

	// window.onload에 대한 대체, 항상 작동함
	window.addEventListener( "load", Completed );
}




// 컬렉션의 값을 가져오고 설정하는 다기능 메서드
// 값이 함수인 경우 선택적으로 실행될 수 있습니다.
var access = function( elems, fn, key, value, chainable,emptyGet, raw ) {
	변수 i = 0,
		len = 요소.길이,
		대량 = 키 == null;

	// 많은 값을 설정합니다.
	if ( toType( 키 ) === "객체" ) {
		연결 가능 = true;
		for (i 키) {
			액세스( elems, fn, i, key[ i ], true,emptyGet, raw );
		}

	// 하나의 값을 설정합니다.
	} else if (값 !== 정의되지 않음) {
		연결 가능 = true;

		if ( !isFunction( 값 ) ) {
			원시 = 사실;
		}

		if (대량) {

			// 전체 세트에 대해 대량 작업이 실행됩니다.
			if ( 원시 ) {
				fn.call(요소, 값);
				fn = 널;

			// ...함수 값을 실행할 때는 제외
			} 또 다른 {
				대량 = fn;
				fn = 함수( elem, _key, value ) {
					returnbulk.call( jQuery( elem ), value );
				};
			}
		}

		만약 (fn) {
			for ( ; i < len; i++ ) {
				fn(
					elems[ i ], 키, 원시 ?
						값 :
						value.call( elems[ i ], i, fn( elems[ i ], key ) )
				);
			}
		}
	}

	if (체인 가능) {
		요소를 반환합니다.
	}

	// 가져오기
	if (대량) {
		return fn.call( elems );
	}

	렌을 돌려줘? fn( elems[ 0 ], key ) : 비어 있음Get;
};


// 카멜라이징을 위해 점선 문자열과 일치합니다.
var rmsPrefix = /^-ms-/,
	rdashAlpha = /-([az])/g;

// CamelCase에서 교체()에 대한 콜백으로 사용됩니다.
함수 fcamelCase( _all, 문자 ) {
	return letter.toUpperCase();
}

// 점선을 camelCase로 변환합니다. CSS 및 데이터 모듈에서 사용됨
// 지원: IE <=9 - 11, 엣지 12 - 15
// Microsoft는 공급업체 접두어를 사용하는 것을 잊었습니다(#9572).
함수 camelCase(문자열) {
	return string.replace( rmsPrefix, "ms-" ).replace( rdashAlpha, fcamelCase );
}
var acceptData = 함수( 소유자 ) {

	// 다음만 허용됩니다.
	// - 노드
	// - Node.ELEMENT_NODE
	// - Node.DOCUMENT_NODE
	// - 물체
	// - 어느
	return owner.nodeType === 1 || owner.nodeType === 9 || !( +owner.nodeType );
};




함수 데이터() {
	this.expando = jQuery.expando + Data.uid++;
}

데이터.uid = 1;

데이터.프로토타입 = {

	캐시: 함수( 소유자 ) {

		// 소유자 객체에 이미 캐시가 있는지 확인
		var value = 소유자[ this.expando ];

		// 없으면 새로 생성
		if (!값) {
			값 = {};

			// 최신 브라우저에서는 요소가 아닌 노드에 대한 데이터를 받아들일 수 있습니다.
			// 하지만 그렇게 해서는 안 됩니다. #8335를 참조하세요.
			// 항상 빈 객체를 반환합니다.
			if ( acceptData( 소유자 ) ) {

				// 문자열화되거나 반복될 가능성이 없는 노드인 경우
				// 일반 할당 사용
				if (owner.nodeType) {
					소유자[ this.expando ] = 값;

				// 그렇지 않으면 열거 불가능한 속성으로 보호합니다.
				// 속성을 허용하려면 configurable이 true여야 합니다.
				//데이터 삭제시 삭제
				} 또 다른 {
					Object.defineProperty( 소유자, this.expando, {
						가치: 가치,
						구성 가능: 사실
					} );
				}
			}
		}

		반환값;
	},
	집합: 함수(소유자, 데이터, 값) {
		var 소품,
			캐시 = this.cache( 소유자 );

		// 핸들: [소유자, 키, 값] args
		// 항상 camelCase 키를 사용합니다(gh-2257).
		if ( 데이터 유형 === "문자열" ) {
			캐시[ camelCase( 데이터 ) ] = 값;

		// 처리: [ 소유자, { 속성 } ] 인수
		} 또 다른 {

			// 속성을 하나씩 캐시 객체에 복사합니다.
			for ( 데이터의 소품 ) {
				캐시[ camelCase( prop ) ] = 데이터[ prop ];
			}
		}
		캐시 반환;
	},
	get: 함수( 소유자, 키 ) {
		반환 키 === 정의되지 않음 ?
			this.cache( 소유자 ) :

			// 항상 camelCase 키를 사용합니다(gh-2257).
			소유자[ this.expando ] && 소유자[ this.expando ][ camelCase( key ) ];
	},
	접근: 함수(소유자, 키, 값) {

		// 다음 중 하나에 해당하는 경우:
		//
		// 1. 키가 지정되지 않았습니다.
		// 2. 문자열 키가 지정되었지만 값이 제공되지 않았습니다.
		//
		// "읽기" 경로를 취하고 get 메소드가 결정하도록 허용합니다.
		// 반환할 값은 각각 다음 중 하나입니다.
		//
		// 1. 전체 캐시 객체
		// 2. 키에 저장된 데이터
		//
		if ( 키 === 정의되지 않음 ||
				( ( 키 && 키 유형 === "문자열" ) && 값 === 정의되지 않음 ) ) {

			return this.get( 소유자, 키 );
		}

		// 키가 문자열이 아니거나 키와 값이 모두 아닌 경우
		// 다음 중 하나를 사용하여 지정하거나 (기존 개체) 설정하거나 확장합니다.
		//
		// 1. 속성의 객체
		// 2. 키와 값
		//
		this.set(소유자, 키, 값);

		// "설정된" 경로에는 두 개의 가능한 진입점이 있을 수 있으므로
		// 어떤 경로를 선택했는지에 따라 예상 데이터를 반환합니다.[*]
		반환 값 !== 정의되지 않음 ? 값 : 키;
	},
	제거: 함수( 소유자, 키 ) {
		내가,
			캐시 = 소유자[ this.expando ];

		if ( 캐시 === 정의되지 않음 ) {
			반품;
		}

		if ( 키 !== 정의되지 않음 ) {

			// 배열 또는 공백으로 구분된 키 문자열 지원
			if ( Array.isArray( 키 ) ) {

				// 키가 키의 배열인 경우...
				// 우리는 항상 camelCase 키를 설정하므로 이를 제거합니다.
				키 = key.map( camelCase );
			} 또 다른 {
				키 = camelCase( 키 );

				// 공백이 포함된 키가 있으면 이를 사용합니다.
				// 그렇지 않으면 공백이 아닌 문자를 일치시켜 배열을 만듭니다.
				키 = 캐시의 키 ?
					[ 열쇠 ] :
					( key.match( rnothtmlwhite ) || [] );
			}

			i = 키.길이;

			동안( i-- ) {
				캐시 삭제[ 키[ i ] ];
			}
		}

		// 더 이상 데이터가 없으면 확장을 제거합니다.
		if ( 키 === 정의되지 않음 || jQuery.isEmptyObject( 캐시 ) ) {

			// 지원: 크롬 <=35 - 45
			// 속성을 삭제하면 Webkit 및 Blink 성능이 저하됩니다.
			// DOM 노드에서 생성되므로 대신 정의되지 않음으로 설정됩니다.
			// https://bugs.chromium.org/p/chromium/issues/detail?id=378607 (버그 제한)
			if (owner.nodeType) {
				소유자[ this.expando ] = 정의되지 않음;
			} 또 다른 {
				소유자 삭제[ this.expando ];
			}
		}
	},
	hasData: 함수( 소유자 ) {
		var 캐시 = 소유자[ this.expando ];
		return 캐시 !== 정의되지 않음 && !jQuery.isEmptyObject( 캐시 );
	}
};
var dataPriv = 새 데이터();

var dataUser = 새로운 데이터();



// 구현 요약
//
// 1. 1.9.x 브랜치와 API 표면 및 의미 호환성을 적용합니다.
// 2. 저장 공간을 줄여 모듈의 유지 관리성을 향상시킵니다.
// 단일 메커니즘에 대한 경로입니다.
// 3. "개인" 및 "사용자" 데이터를 지원하기 위해 동일한 단일 메커니즘을 사용합니다.
// 4. "비공개" 데이터를 사용자 코드에 _절대_ 노출하지 않습니다(TODO: Drop _data, _removeData)
// 5. 사용자 개체에 대한 구현 세부 정보 노출을 피하세요(예: 확장 속성)
// 6. 2014년 WeakMap으로의 구현 업그레이드를 위한 명확한 경로 제공

var rbrace = /^(?:\{[\w\W]*\}|\[[\w\W]*\])$/,
	rmultiDash = /[AZ]/g;

함수 getData(데이터) {
	if ( 데이터 === "참" ) {
		사실을 반환;
	}

	if ( 데이터 === "false" ) {
		거짓을 반환;
	}

	if ( 데이터 === "null" ) {
		null을 반환;
	}

	// 문자열이 변경되지 않는 경우에만 숫자로 변환합니다.
	if ( 데이터 === +데이터 + "" ) {
		+데이터를 반환합니다.
	}

	if ( rbrace.test( 데이터 ) ) {
		return JSON.parse( 데이터 );
	}

	데이터를 반환합니다.
}

함수 dataAttr( elem, 키, 데이터 ) {
	변수 이름;

	// 내부적으로 아무것도 발견되지 않은 경우, 가져오기를 시도합니다.
	// HTML5 data-* 속성의 데이터
	if ( data === 정의되지 않음 && elem.nodeType === 1 ) {
		name = "data-" + key.replace( rmultiDash, "-$&" ).toLowerCase();
		data = elem.getAttribute(이름);

		if ( 데이터 유형 === "문자열" ) {
			노력하다 {
				데이터 = getData(데이터);
			} 잡기 ( 전자 ) {}

			// 나중에 변경되지 않도록 데이터를 설정했는지 확인하세요.
			dataUser.set(요소, 키, 데이터);
		} 또 다른 {
			데이터 = 정의되지 않음;
		}
	}
	데이터를 반환합니다.
}

jQuery.확장({
	hasData: 함수( elem ) {
		return dataUser.hasData( elem ) || dataPriv.hasData( elem );
	},

	데이터: 함수(요소, 이름, 데이터) {
		return dataUser.access( elem, 이름, 데이터 );
	},

	RemoveData: 함수( 요소, 이름 ) {
		dataUser.remove(요소, 이름);
	},

	// TODO: 이제 _data 및 _removeData에 대한 모든 호출이 대체되었습니다.
	// dataPriv 메서드를 직접 호출하면 더 이상 사용되지 않을 수 있습니다.
	_data: 함수( 요소, 이름, 데이터 ) {
		return dataPriv.access( elem, 이름, 데이터 );
	},

	_removeData: 함수( 요소, 이름 ) {
		dataPriv.remove( elem, 이름 );
	}
} );

jQuery.fn.extend({
	데이터: 함수(키, 값) {
		var i, 이름, 데이터,
			요소 = 이[ 0 ],
			attrs = elem && elem.attributes;

		// 모든 값을 가져옵니다.
		if ( 키 === 정의되지 않음 ) {
			if (this.length) {
				데이터 = dataUser.get( elem );

				if ( elem.nodeType === 1 && !dataPriv.get( elem, "hasDataAttrs" ) ) {
					i = 속성.길이;
					동안( i-- ) {

						// 지원: IE 11만 해당
						// attrs 요소는 null일 수 있습니다. (#14894)
						if ( attrs[ i ] ) {
							이름 = attrs[ i ].name;
							if ( name.indexOf( "data-" ) === 0 ) {
								name = camelCase( name.slice( 5 ) );
								dataAttr( 요소, 이름, 데이터[ 이름 ] );
							}
						}
					}
					dataPriv.set( elem, "hasDataAttrs", true );
				}
			}

			데이터를 반환합니다.
		}

		// 여러 값을 설정합니다.
		if ( 키 유형 === "객체" ) {
			return this.each( function() {
				dataUser.set( this, key );
			} );
		}

		return access( this, function( value ) {
			변수 데이터;

			// 호출하는 jQuery 객체(요소 일치)가 비어 있지 않습니다.
			// (따라서 this[ 0 ]에 요소가 나타납니다)
			// `value` 매개변수가 정의되지 않았습니다. 빈 jQuery 객체
			// elem = this[ 0 ]에 대해 `undefine`이 발생합니다.
			// 데이터 캐시를 읽으려고 시도하면 예외가 발생합니다.
			if ( 요소 && 값 === 정의되지 않음 ) {

				// 캐시에서 데이터를 가져오려고 시도합니다.
				// 키는 항상 데이터에서 camelCased입니다.
				data = dataUser.get( elem, key );
				if ( 데이터 !== 정의되지 않음 ) {
					데이터를 반환합니다.
				}

				// 데이터를 "발견"하려고 시도합니다.
				// HTML5 사용자 정의 데이터-* 속성
				data = dataAttr( elem, key );
				if ( 데이터 !== 정의되지 않음 ) {
					데이터를 반환합니다.
				}

				// 정말 열심히 노력했지만 데이터가 존재하지 않습니다.
				반품;
			}

			// 데이터 설정...
			this.each( 함수() {

				// 우리는 항상 camelCased 키를 저장합니다.
				dataUser.set(this, 키, 값);
			} );
		}, null, 값, 인수.길이 > 1, null, true );
	},

	제거데이터: 함수( 키 ) {
		return this.each( function() {
			dataUser.remove( this, key );
		} );
	}
} );


jQuery.확장({
	대기열: 함수(요소, 유형, 데이터) {
		var 대기열;

		if ( 요소 ) {
			유형 = ( 유형 || "fx" ) + "큐";
			queue = dataPriv.get( elem, type );

			// 단순한 조회인 경우 빠르게 나가서 대기열 제거 속도를 높입니다.
			만약 (데이터) {
				if ( !queue || Array.isArray( 데이터 ) ) {
					queue = dataPriv.access( elem, type, jQuery.makeArray( data ) );
				} 또 다른 {
					queue.push(데이터);
				}
			}
			반환 대기열 || [];
		}
	},

	대기열 제거: 함수( elem, 유형 ) {
		유형 = 유형 || "FX";

		var queue = jQuery.queue( elem, type ),
			startLength = queue.length,
			fn = queue.shift(),
			후크 = jQuery._queueHooks( elem, type ),
			다음 = 함수() {
				jQuery.dequeue( elem, type );
			};

		// fx 대기열이 대기열에서 제거되면 항상 진행 센티널을 제거합니다.
		if ( fn === "진행 중" ) {
			fn = queue.shift();
			시작길이--;
		}

		만약 (fn) {

			// fx 대기열이 종료되는 것을 방지하기 위해 진행 센티널을 추가합니다.
			// 자동으로 대기열에서 제거됨
			if ( 유형 === "fx" ) {
				queue.unshift( "진행 중" );
			}

			// 마지막 대기열 중지 기능을 정리합니다.
			Hooks.stop 삭제;
			fn.call( elem, next, Hooks );
		}

		if ( !startLength && 후크 ) {
			Hooks.empty.fire();
		}
	},

	// 공개되지 않음 - queueHooks 객체를 생성하거나 현재 객체를 반환합니다.
	_queueHooks: 함수( elem, 유형 ) {
		var key = 유형 + "queueHooks";
		return dataPriv.get( elem, key ) || dataPriv.access( elem, 키, {
			비어 있음: jQuery.Callbacks( "한 번 메모리" ).add( function() {
				dataPriv.remove( elem, [ type + "queue", key ] );
			} )
		} );
	}
} );

jQuery.fn.extend({
	대기열: 함수( 유형, 데이터 ) {
		var 설정자 = 2;

		if ( 유형의 유형 !== "문자열" ) {
			데이터 = 유형;
			유형 = "fx";
			세터--;
		}

		if (인수.길이 < setter) {
			return jQuery.queue( this[ 0 ], type );
		}

		반환 데이터 === 정의되지 않음?
			이것 :
			this.each( 함수() {
				var queue = jQuery.queue( this, type, data );

				// 이 대기열에 대한 후크를 보장합니다.
				jQuery._queueHooks( this, type );

				if ( type === "fx" && 대기열[ 0 ] !== "진행 중" ) {
					jQuery.dequeue( this, type );
				}
			} );
	},
	대기열 제거: 함수( 유형 ) {
		return this.each( function() {
			jQuery.dequeue( this, type );
		} );
	},
	ClearQueue: 함수( 유형 ) {
		return this.queue( type || "fx", [] );
	},

	// 특정 유형의 대기열이 있을 때 Promise가 해결되도록 합니다.
	// 비어 있습니다(fx는 기본적으로 유형입니다)
	약속: 함수( 유형, obj ) {
		vartmp,
			개수 = 1,
			연기 = jQuery.Deferred(),
			요소 = 이것,
			i = this.length,
			해결 = 함수() {
				if ( !( --count ) ) {
					defer.resolveWith( 요소, [ 요소 ] );
				}
			};

		if ( 유형의 유형 !== "문자열" ) {
			obj = 유형;
			유형 = 정의되지 않음;
		}
		유형 = 유형 || "FX";

		동안( i-- ) {
			tmp = dataPriv.get( elements[ i ], type + "queueHooks" );
			if ( tmp && tmp.empty ) {
				카운트++;
				tmp.empty.add(해결);
			}
		}
		해결하다();
		return defer.promise( obj );
	}
} );
var pnum = ( /[+-]?(?:\d*\.|)\d+(?:[eE][+-]?\d+|)/ ).source;

var rcssNum = new RegExp( "^(?:([+-])=|)(" + pnum + ")([az%]*)$", "i" );


var cssExpand = [ "위쪽", "오른쪽", "아래쪽", "왼쪽" ];

var documentElement = document.documentElement;



	var isAttached = function( elem ) {
			return jQuery.contains( elem.ownerDocument, elem );
		},
		구성됨 = { 구성됨: true };

	// 지원: IE 9 - 11+, Edge 12 - 18+, iOS 10.0 - 10.2 전용
	// 가능한 경우 Shadow DOM 경계를 넘어 첨부 파일을 확인합니다(gh-3504).
	// 지원: iOS 10.0-10.2 전용
	// 초기 iOS 10 버전은 `attachShadow`를 지원하지만 `getRootNode`는 지원하지 않습니다.
	// 오류가 발생합니다. `getRootNode`를 확인해야 합니다.
	if( documentElement.getRootNode ) {
		isAttached = 함수( elem ) {
			return jQuery.contains( elem.ownerDocument, elem ) ||
				elem.getRootNode( 구성 ) === elem.ownerDocument;
		};
	}
var isHiddenWithinTree = function( elem, el ) {

		// isHiddenWithinTree는 jQuery#filter 함수에서 호출될 수 있습니다.
		// 이 경우 요소는 두 번째 인수가 됩니다.
		elem = 엘 || 요소;

		// 인라인 스타일이 모든 것보다 우선합니다.
		return elem.style.display === "없음" ||
			elem.style.display === "" &&

			// 그렇지 않으면 계산된 스타일을 확인합니다.
			// 지원: 파이어폭스 <=43 - 45
			// 연결이 끊긴 요소는 계산된 display: none을 가질 수 있으므로 먼저 elem이
			// 문서에서.
			isAttached( 요소 ) &&

			jQuery.css( elem, "display" ) === "없음";
	};



함수 adjustCSS( elem, prop, valueParts, tween ) {
	var 조정, 스케일,
		maxIterations = 20,
		currentValue = 트윈?
			기능() {
				tween.cur()를 반환합니다.
			} :
			기능() {
				return jQuery.css( elem, prop, "" );
			},
		초기 = 현재값(),
		단위 = valueParts && valueParts[ 3 ] || ( jQuery.cssNumber[ prop ] ? "" : "px" ),

		// 잠재적인 단위 불일치에 대해 시작 값 계산이 필요합니다.
		initialInUnit = elem.nodeType &&
			( jQuery.cssNumber[ prop ] || 단위 !== "px" && +initial ) &&
			rcssNum.exec( jQuery.css( elem, prop ) );

	if (initialInUnit &&initialInUnit[ 3 ] !== 단위 ) {

		// 지원: 파이어폭스 <=54
		// CSS 상한의 간섭을 방지하기 위해 반복 대상 값을 절반으로 줄입니다(gh-2144).
		초기 = 초기 / 2;

		// jQuery.css에 의해 보고된 신뢰 단위
		단위 = 단위 || 초기InUnit[ 3 ];

		// 0이 아닌 시작점에서 반복적으로 근사화합니다.
		initialInUnit = +초기 || 1;

		while( maxIterations-- ) {

			// 최선의 추측을 평가하고 업데이트합니다(2배로 추측하면 0이 됩니다).
			// 눈금이 1과 같거나 1을 넘으면 종료됩니다(기존*새 제품을 양수가 아닌 값으로 만듭니다).
			jQuery.style( elem, prop,initialInUnit + 단위 );
			if ( ( 1 - 규모 ) * ( 1 - ( 규모 = currentValue() / 초기 || 0.5 ) ) <= 0 ) {
				최대 반복 = 0;
			}
			initialInUnit=initialInUnit/스케일;

		}

		initialInUnit=initialInUnit*2;
		jQuery.style( elem, prop,initialInUnit + 단위 );

		// 나중에 트윈 속성을 업데이트하는지 확인하세요.
		valueParts = valueParts || [];
	}

	if ( valueParts ) {
		initialInUnit = +initialInUnit || +이니셜 || 0;

		// 지정된 경우 상대 오프셋(+=/-=)을 적용합니다.
		조정됨 = valueParts[ 1 ] ?
			initialInUnit + ( valueParts[ 1 ] + 1 ) * valueParts[ 2 ] :
			+valueParts[ 2 ];
		if (트윈) {
			tween.unit = 단위;
			tween.start = 초기InUnit;
			tween.end = 조정됨;
		}
	}
	조정된 수익;
}


var defaultDisplayMap = {};

함수 getDefaultDisplay( elem ) {
	온도 변화,
		doc = elem.ownerDocument,
		nodeName = elem.nodeName,
		디스플레이 = defaultDisplayMap[ nodeName ];

	if (디스플레이) {
		반환 디스플레이;
	}

	temp = doc.body.appendChild( doc.createElement( nodeName ) );
	display = jQuery.css( temp, "display" );

	temp.parentNode.removeChild( 임시 );

	if ( 표시 === "없음" ) {
		표시 = "차단";
	}
	defaultDisplayMap[ nodeName ] = 표시;

	반환 디스플레이;
}

함수 showHide(요소, 표시) {
	var 디스플레이, 요소,
		값 = [],
		인덱스 = 0,
		길이 = 요소.길이;

	// 변경해야 하는 요소에 대한 새 표시 값을 결정합니다.
	for ( ; 인덱스 < 길이; 인덱스++ ) {
		elem = 요소[ 인덱스 ];
		if ( !elem.style ) {
			계속하다;
		}

		디스플레이 = elem.style.display;
		만약 (보여준다) {

			// 계단식으로 숨겨진 요소에 가시성을 강제하기 때문에 즉각적이고 느린
			// 비어 있지 않은 표시 값이 없으면 이 첫 번째 루프에서 확인이 필요합니다(둘 중 하나).
			// 인라인 또는 복원 예정)
			if ( 표시 === "없음" ) {
				값[ index ] = dataPriv.get( elem, "display" ) || 없는;
				if ( !values[ 인덱스 ] ) {
					elem.style.display = "";
				}
			}
			if ( elem.style.display === "" && isHiddenWithinTree( elem ) ) {
				값[ index ] = getDefaultDisplay( elem );
			}
		} 또 다른 {
			if ( 표시 !== "없음" ) {
				값[ index ] = "없음";

				// 덮어쓰는 내용을 기억하세요.
				dataPriv.set( elem, "display", display );
			}
		}
	}

	// 지속적인 리플로우를 피하기 위해 두 번째 루프에서 요소 표시를 설정합니다.
	for ( 인덱스 = 0; 인덱스 < 길이; 인덱스++ ) {
		if ( 값[ 인덱스 ] != null ) {
			요소[ 인덱스 ].style.display = 값[ 인덱스 ];
		}
	}

	요소를 반환합니다.
}

jQuery.fn.extend({
	표시: 함수() {
		return showHide( this, true );
	},
	숨기기: 함수() {
		return showHide( this );
	},
	토글: 함수( 상태 ) {
		if ( 상태 유형 === "부울" ) {
			반환 상태? this.show() : this.hide();
		}

		return this.each( function() {
			if ( isHiddenWithinTree( this ) ) {
				jQuery( this ).show();
			} 또 다른 {
				jQuery( this ).hide();
			}
		} );
	}
} );
var rcheckableType = ( /^(?:checkbox|radio)$/i );

var rtagName = ( /<([az][^\/\0>\x20\t\r\n\f]*)/i );

var rscriptType = ( /^$|^module$|\/(?:java|ecma)script/i );



( 기능() {
	var 조각 = document.createDocumentFragment(),
		div = 조각.appendChild( document.createElement( "div" ) ),
		input = document.createElement( "input" );

	// 지원: Android 4.0 - 4.3만 해당
	// 이름이 설정된 경우 손실된 상태를 확인합니다(#11217).
	// 지원: Windows 웹 앱(WWA)
	// `name` 및 `type`은 WWA에 대해 .setAttribute를 사용해야 합니다(#14901).
	input.setAttribute( "type", "radio" );
	input.setAttribute( "checked", "checked" );
	input.setAttribute( "이름", "t" );

	div.appendChild(입력);

	// 지원: Android <=4.1 전용
	// 이전 WebKit은 확인된 상태를 조각에서 올바르게 복제하지 않습니다.
	support.checkClone = div.cloneNode( true ).cloneNode( true ).lastChild.checked;

	// 지원: IE <=11만 해당
	// 텍스트 영역(및 체크박스) defaultValue가 제대로 복제되었는지 확인하세요.
	div.innerHTML = "<textarea>x</textarea>";
	support.noCloneChecked = !!div.cloneNode( true ).lastChild.defaultValue;

	// 지원: IE <=9만 해당
	// IE <=9는 <option> 태그를 외부에 삽입할 때 해당 내용으로 대체합니다.
	// 선택 요소.
	div.innerHTML = "<옵션></옵션>";
	support.option = !!div.lastChild;
} )();


// XHTML을 지원하려면 이 태그를 닫아야 합니다. (#13200)
var 랩맵 = {

	// XHTML 파서는 마법처럼 요소를 삽입하지 않습니다.
	// 태그 수프 파서와 같은 방식입니다. 그래서 우리는 단축할 수 없습니다
	// <tbody>나 기타 필수 요소를 생략하면 됩니다.
	thead: [ 1, "<테이블>", "</테이블>" ],
	col: [ 2, "<table><colgroup>", "</colgroup></table>" ],
	tr: [ 2, "<table><tbody>", "</tbody></table>" ],
	td: [ 3, "<table><tbody><tr>", "</tr></tbody></table>" ],

	_default: [ 0, "", "" ]
};

WrapMap.tbody = WrapMap.tfoot = WrapMap.colgroup = WrapMap.caption = WrapMap.thead;
WrapMap.th = WrapMap.td;

// 지원: IE <=9만 해당
if ( !support.option ) {
	WrapMap.optgroup = WrapMap.option = [ 1, "<select multiple='multiple'>", "</select>" ];
}


함수 getAll(컨텍스트, 태그) {

	// 지원: IE <=9 - 11만 해당
	// 호스트 객체에서 인수가 없는 메서드 호출을 방지하려면 typeof를 사용하세요. (#15151)
	var ret;

	if ( typeof context.getElementsByTagName !== "정의되지 않음" ) {
		ret = context.getElementsByTagName( 태그 || "*" );

	} else if ( typeof context.querySelectorAll !== "정의되지 않음" ) {
		ret = context.querySelectorAll( tag || "*" );

	} 또 다른 {
		ret = [];
	}

	if ( 태그 === 정의되지 않음 || tag && nodeName( context, tag ) ) {
		return jQuery.merge( [ context ], ret );
	}

	반환 ret;
}


// 스크립트를 이미 평가된 것으로 표시합니다.
함수 setGlobalEval( elems, refElements ) {
	변수 i = 0,
		l = 요소.길이;

	for ( ; i < l; i++ ) {
		dataPriv.set(
			요소[ i ],
			"글로벌 평가",
			!refElements || dataPriv.get( refElements[ i ], "globalEval" )
		);
	}
}


var rhtml = /<|&#?\w+;/;

function buildFragment( 요소, 컨텍스트, 스크립트, 선택, 무시됨 ) {
	var elem, tmp, 태그, 랩, 첨부, j,
		조각 = context.createDocumentFragment(),
		노드 = [],
		나는 = 0,
		l = 요소.길이;

	for ( ; i < l; i++ ) {
		elem = 요소[ i ];

		if ( 요소 || 요소 === 0 ) {

			// 노드를 직접 추가
			if ( toType( elem ) === "객체" ) {

				// 지원: Android <=4.0 전용, PhantomJS 1 전용
				// push.apply(_, arraylike)는 고대 WebKit에서 발생합니다.
				jQuery.merge( 노드, elem.nodeType ? [ elem ] : elem );

			// HTML이 아닌 텍스트 노드로 변환
			} else if ( !rhtml.test( elem ) ) {
				node.push( context.createTextNode( elem ) );

			// HTML을 DOM 노드로 변환
			} 또 다른 {
				tmp = tmp || 조각.appendChild( context.createElement( "div" ) );

				// 표준 표현을 역직렬화합니다.
				tag = ( rtagName.exec( elem ) || [ "", "" ] )[ 1 ].toLowerCase();
				랩 = 랩맵[ 태그 ] || WrapMap._default;
				tmp.innerHTML = 랩[ 1 ] + jQuery.htmlPrefilter( elem ) + 랩[ 2 ];

				// 래퍼를 통해 올바른 콘텐츠로 내려갑니다.
				j = 랩[ 0 ];
				동안( j-- ) {
					tmp = tmp.lastChild;
				}

				// 지원: Android <=4.0 전용, PhantomJS 1 전용
				// push.apply(_, arraylike)는 고대 WebKit에서 발생합니다.
				jQuery.merge(노드, tmp.childNodes);

				// 최상위 컨테이너를 기억하세요
				tmp = 조각.firstChild;

				// 생성된 노드가 고아인지 확인합니다(#12392).
				tmp.textContent = "";
			}
		}
	}

	// 프래그먼트에서 래퍼 제거
	조각.textContent = "";

	나는 = 0;
	while ( ( elem = 노드[ i++ ] ) ) {

		// 이미 컨텍스트 컬렉션에 있는 요소를 건너뜁니다(trac-4087).
		if ( 선택 && jQuery.inArray( elem, 선택 ) > -1 ) {
			if (무시됨) {
				무시됨.push( elem );
			}
			계속하다;
		}

		attachment = isAttached( elem );

		// 조각에 추가
		tmp = getAll(fragment.appendChild( elem ), "script" );

		// 스크립트 평가 기록을 유지합니다.
		if (첨부됨) {
			setGlobalEval(tmp);
		}

		// 실행 파일 캡처
		if (스크립트) {
			j = 0;
			while ( ( elem = tmp[ j++ ] ) ) {
				if ( rscriptType.test( elem.type || "" ) ) {
					scripts.push( elem );
				}
			}
		}
	}

	조각 반환;
}


var rtypenamespace = /^([^.]*)(?:\.(.+)|)/;

함수 returnTrue() {
	사실을 반환;
}

함수 returnFalse() {
	거짓을 반환;
}

// 지원: IE <=9 - 11+
// focus()와 Blur()는 작동하지 않는 경우를 제외하고는 비동기적입니다.
// 따라서 요소가 이미 활성화된 경우 포커스가 동기화될 것으로 예상합니다.
// 요소가 아직 활성화되지 않은 경우 동기식으로 흐리게 처리됩니다.
// (포커스와 블러는 지원되는 다른 브라우저에서는 항상 동기식입니다.
// 이는 우리가 믿을 수 있는 시기를 정의합니다).
함수 ExpectSync( elem, 유형 ) {
	return ( elem === safeActiveElement() ) === ( type === "focus" );
}

// 지원: IE <=9만 해당
// document.activeElement에 액세스하면 예기치 않게 오류가 발생할 수 있습니다.
// https://bugs.jquery.com/ticket/13393
함수 safeActiveElement() {
	노력하다 {
		document.activeElement를 반환합니다.
	} 잡기 (오류) { }
}

함수 on( elem, 유형, 선택기, 데이터, fn, one ) {
	var origFn, 유형;

	// 유형은 유형/핸들러의 맵일 수 있습니다.
	if ( 유형of 유형 === "객체" ) {

		// ( 유형-객체, 선택기, 데이터)
		if ( 선택기 유형 !== "string" ) {

			// ( 유형-객체, 데이터)
			데이터 = 데이터 || 선택자;
			선택기 = 정의되지 않음;
		}
		for ( 유형을 입력하세요 ) {
			on( 요소, 유형, 선택기, 데이터, 유형[ 유형 ], 하나 );
		}
		요소를 반환;
	}

	if ( 데이터 == null && fn == null ) {

		// ( 유형, fn )
		fn = 선택자;
		데이터 = 선택기 = 정의되지 않음;
	} else if (fn == null ) {
		if ( 선택기 유형 === "문자열" ) {

			// ( 유형, 선택기, fn )
			fn = 데이터;
			데이터 = 정의되지 않음;
		} 또 다른 {

			// ( 유형, 데이터, fn )
			fn = 데이터;
			데이터 = 선택자;
			선택기 = 정의되지 않음;
		}
	}
	if (fn === false ) {
		fn = returnFalse;
	} else if ( !fn ) {
		요소를 반환;
	}

	if ( 하나 === 1 ) {
		origFn = fn;
		fn = 함수(이벤트) {

			// 이벤트에 정보가 포함되어 있으므로 빈 세트를 사용할 수 있습니다.
			jQuery().off(이벤트);
			return origFn.apply( this, 인수 );
		};

		// 호출자가 origFn을 사용하여 제거할 수 있도록 동일한 GUID를 사용합니다.
		fn.guid = origFn.guid || ( origFn.guid = jQuery.guid++ );
	}
	return elem.each( function() {
		jQuery.event.add(this, 유형, fn, 데이터, 선택기);
	} );
}

/*
 * 이벤트 관리를 위한 도우미 기능 - 공개 인터페이스의 일부가 아닙니다.
 * 많은 아이디어에 대해 Dean Edwards의 addEvent 라이브러리를 활용합니다.
 */
jQuery.이벤트 = {

	전역: {},

	추가: 함수( elem, 유형, 핸들러, 데이터, 선택기) {

		var handlerObjIn, eventHandle, tmp,
			이벤트, t, handlerObj,
			특수, 핸들러, 유형, 네임스페이스, origType,
			elemData = dataPriv.get( elem );

		// 데이터를 받아들이는 객체에만 이벤트를 연결합니다.
		if ( !acceptData( elem ) ) {
			반품;
		}

		// 호출자는 핸들러 대신 사용자 정의 데이터 객체를 전달할 수 있습니다.
		if ( handler.handler ) {
			handlerObjIn = 핸들러;
			핸들러 = handlerObjIn.handler;
			선택기 = handlerObjIn.selector;
		}

		// 잘못된 선택자가 연결 시 예외를 발생시키는지 확인합니다.
		// elem이 요소가 아닌 노드(예: document)인 경우 documentElement에 대해 평가합니다.
		if (선택자) {
			jQuery.find.matchesSelector( documentElement, selector );
		}

		// 핸들러가 나중에 찾거나 제거하는 데 사용되는 고유 ID를 가지고 있는지 확인하십시오.
		if ( !handler.guid ) {
			handler.guid = jQuery.guid++;
		}

		// 요소의 이벤트 구조와 메인 핸들러를 초기화합니다(첫 번째인 경우).
		if ( !( 이벤트 = elemData.events ) ) {
			events = elemData.events = Object.create( null );
		}
		if ( !( eventHandle = elemData.handle ) ) {
			eventHandle = elemData.handle = function( e ) {

				// jQuery.event.trigger()의 두 번째 이벤트를 삭제하고
				//페이지가 언로드된 후 이벤트가 호출될 때
				return typeof jQuery !== "정의되지 않음" && jQuery.event.triggered !== e.type ?
					jQuery.event.dispatch.apply( elem, 인수 ) : 정의되지 않음;
			};
		}

		// 공백으로 구분된 여러 이벤트를 처리합니다.
		유형 = ( 유형 || "" ).match( rnothtmlwhite ) || [ "" ];
		t = 유형.길이;
		동안 ( t-- ) {
			tmp = rtypenamespace.exec( 유형[ t ] ) || [];
			유형 = origType = tmp[ 1 ];
			네임스페이스 = ( tmp[ 2 ] || "" ).split( "." ).sort();

			// *반드시* 유형이 있어야 하며, 네임스페이스 전용 핸들러를 첨부하지 마세요.
			if ( !type ) {
				계속하다;
			}

			// 이벤트 유형이 변경되면 변경된 유형에 대한 특수 이벤트 핸들러를 사용합니다.
			특수 = jQuery.event.special[ 유형 ] || {};

			// 선택기가 정의된 경우 특수 이벤트 API 유형을 결정하고, 그렇지 않으면 지정된 유형을 결정합니다.
			유형 = ( 선택기 ? 특수.delegateType : 특수.bindType ) || 유형;

			// 새로 재설정된 유형에 따라 특수 항목을 업데이트합니다.
			특수 = jQuery.event.special[ 유형 ] || {};

			// handlerObj는 모든 이벤트 핸들러에 전달됩니다.
			handlerObj = jQuery.extend({
				유형: 유형,
				원본 유형: 원본 유형,
				데이터: 데이터,
				핸들러: 핸들러,
				guid: handler.guid,
				선택자: 선택자,
				needContext: 선택기 && jQuery.expr.match.needsContext.test( 선택기 ),
				네임스페이스: 네임스페이스.join( "." )
			},handleObjIn);

			// 우리가 첫 번째라면 이벤트 핸들러 큐를 초기화합니다.
			if ( !( 핸들러 = 이벤트[ 유형 ] ) ) {
				핸들러 = 이벤트[ 유형 ] = [];
				handlers.delegateCount = 0;

				// 특수 이벤트 핸들러가 false를 반환하는 경우에만 addEventListener를 사용합니다.
				if ( !special.setup ||
					특수.setup.call( elem, 데이터, 네임스페이스, eventHandle ) === false ) {

					if( elem.addEventListener ) {
						elem.addEventListener( type, eventHandle );
					}
				}
			}

			if (특수.추가) {
				특수.add.call( elem, handlerObj );

				if ( !handleObj.handler.guid ) {
					handlerObj.handler.guid = handler.guid;
				}
			}

			// 요소의 핸들러 목록에 추가하고 앞에 대리자를 추가합니다.
			if (선택자) {
				handlers.splice( handlers.delegateCount++, 0, handlerObj );
			} 또 다른 {
				handlers.push(handleObj);
			}

			// 이벤트 최적화를 위해 어떤 이벤트가 사용되었는지 추적합니다.
			jQuery.event.global[ 유형 ] = true;
		}

	},

	// 요소에서 이벤트 또는 이벤트 세트를 분리합니다.
	제거: 함수( elem, 유형, 핸들러, 선택기, mappedTypes ) {

		var j, origCount, tmp,
			이벤트, t, handlerObj,
			특수, 핸들러, 유형, 네임스페이스, origType,
			elemData = dataPriv.hasData( elem ) && dataPriv.get( elem );

		if ( !elemData || !( events = elemData.events ) ) {
			반품;
		}

		// 유형의 각 type.namespace에 대해 한 번씩; 유형은 생략될 수 있음
		유형 = ( 유형 || "" ).match( rnothtmlwhite ) || [ "" ];
		t = 유형.길이;
		동안 ( t-- ) {
			tmp = rtypenamespace.exec( 유형[ t ] ) || [];
			유형 = origType = tmp[ 1 ];
			네임스페이스 = ( tmp[ 2 ] || "" ).split( "." ).sort();

			// 요소에 대한 모든 이벤트(제공된 경우 이 네임스페이스에 있음)를 바인딩 해제합니다.
			if ( !type ) {
				for ( 이벤트 입력 ) {
					jQuery.event.remove( elem, 유형 + 유형[ t ], 핸들러, 선택기, true );
				}
				계속하다;
			}

			특수 = jQuery.event.special[ 유형 ] || {};
			유형 = ( 선택기 ? 특수.delegateType : 특수.bindType ) || 유형;
			핸들러 = 이벤트[ 유형 ] || [];
			tmp = tmp[ 2 ] &&
				new RegExp( "(^|\\.)" + 네임스페이스.join( "\\.(?:.*\\.|)" ) + "(\\.|$)" );

			// 일치하는 이벤트 제거
			origCount = j = handlers.length;
			동안( j-- ) {
				handlerObj = 핸들러[ j ];

				if ( ( mappedTypes || origType === handlerObj.origType ) &&
					( !handler || handler.guid === handlerObj.guid ) &&
					( !tmp || tmp.test(handleObj.namespace) ) &&
					( !selector || 선택기 === handlerObj.selector ||
						선택기 === "**" && handlerObj.selector ) ) {
					handlers.splice(j, 1);

					if (handleObj.selector) {
						handlers.delegateCount--;
					}
					if (특수.제거) {
						Special.remove.call( elem, handlerObj );
					}
				}
			}

			// 무언가를 제거했는데 더 이상 핸들러가 존재하지 않으면 일반 이벤트 핸들러를 제거합니다.
			// (특수 이벤트 핸들러 제거 중 무한 재귀 가능성 방지)
			if ( origCount && !handlers.length ) {
				if ( !special.teardown ||
					Special.teardown.call( elem, 네임스페이스, elemData.handle ) === false ) {

					jQuery.removeEvent( elem, type, elemData.handle );
				}

				이벤트 삭제[ 유형 ];
			}
		}

		// 더 이상 사용되지 않는 경우 데이터와 확장을 제거합니다.
		if ( jQuery.isEmptyObject( 이벤트 ) ) {
			dataPriv.remove( elem, "이벤트 처리" );
		}
	},

	파견: 함수(nativeEvent) {

		var i, j, ret, 일치, handlerObj, handlerQueue,
			args = 새 배열(args.length),

			// 기본 이벤트 객체에서 쓰기 가능한 jQuery.Event를 만듭니다.
			이벤트 = jQuery.event.fix(nativeEvent),

			핸들러 = (
				dataPriv.get( this, "events" ) || 객체.생성( null )
			)[ 이벤트.유형 ] || [],
			특수 = jQuery.event.special[ event.type ] || {};

		// (읽기 전용) 기본 이벤트 대신 수정된 jQuery.Event를 사용합니다.
		인수[ 0 ] = 이벤트;

		for ( i = 1; i < 인수.길이; i++ ) {
			인수[ i ] = 인수[ i ];
		}

		event.delegateTarget = this;

		// 매핑된 유형에 대한 preDispatch 후크를 호출하고 원하는 경우 구제되도록 둡니다.
		if ( 특수.preDispatch && 특수.preDispatch.call( this, 이벤트 ) === false ) {
			반품;
		}

		// 핸들러 결정
		handlerQueue = jQuery.event.handlers.call(this, 이벤트, 핸들러);

		// 대리자를 먼저 실행합니다. 그들은 우리 아래에서 전파를 중단하고 싶어할 수도 있습니다
		나는 = 0;
		while ( ( match = handlerQueue[ i++ ] ) && !event.isPropagationStopped() ) {
			event.currentTarget = match.elem;

			j = 0;
			while ( ( handlerObj = match.handlers[ j++ ] ) &&
				!event.isImmediatePropagationStopped() ) {

				// 이벤트에 네임스페이스가 있는 경우 각 핸들러는 다음과 같은 경우에만 호출됩니다.
				// 특별히 유니버설 또는 해당 네임스페이스는 이벤트의 상위 집합입니다.
				if ( !event.rnamespace || handlerObj.namespace === false ||
					event.rnamespace.test(handleObj.namespace) ) {

					event.handleObj = 핸들Obj;
					event.data=handleObj.data;

					ret = ( ( jQuery.event.special[ handlerObj.origType ] || {} ).handle ||
						handlerObj.handler ).apply( match.elem, args );

					if (ret !== 정의되지 않음) {
						if ( ( event.result = ret ) === false ) {
							event.preventDefault();
							event.stopPropagation();
						}
					}
				}
			}
		}

		// 매핑된 유형에 대해 postDispatch 후크를 호출합니다.
		if (special.postDispatch) {
			Special.postDispatch.call( this, event );
		}

		이벤트.결과 반환;
	},

	핸들러: 함수(이벤트, 핸들러) {
		var i,handleObj,sel,matchedHandlers,matchedSelectors,
			handlerQueue = [],
			대리자카운트 = handlers.delegateCount,
			현재 = 이벤트.대상;

		// 위임 핸들러 찾기
		if (델리게이트카운트 &&

			// 지원: IE <=9
			// 블랙홀 SVG <use> 인스턴스 트리 (trac-13180)
			현재.노드 유형 &&

			// 지원: 파이어폭스 <=42
			// 기본이 아닌 포인터 버튼을 나타내는 사양 위반 클릭을 억제합니다(trac-3861).
			// https://www.w3.org/TR/DOM-Level-3-Events/#event-type-click
			// 지원: IE 11만 해당
			// ...그러나 `버튼` -1을 가질 수 있는 라디오 입력의 화살표 키 "클릭"은 아님 (gh-2343)
			!( event.type === "클릭" && event.button >= 1 ) ) {

			for ( ; cur !== this; cur = cur.parentNode || this ) {

				// 요소가 아닌 것은 확인하지 않습니다. (#13208)
				// 비활성화된 요소(#6911, #8165, #11382, #11764)에 대한 클릭을 처리하지 않습니다.
				if ( cur.nodeType === 1 && !( event.type === "클릭" && cur.disabled === true ) ) {
					matchHandlers = [];
					matchSelectors = {};
					for ( i = 0; i < 델리게이트카운트; i++ ) {
						handlerObj = 핸들러[ i ];

						// Object.prototype 속성과 충돌하지 마세요. (#13203)
						sel = handlerObj.selector + " ";

						if ( matchSelectors[ sel ] === 정의되지 않음 ) {
							matchSelectors[ sel ] = handlerObj.needsContext ?
								jQuery( sel, this ).index( cur ) > -1 :
								jQuery.find( sel, this, null, [ cur ] ).length;
						}
						if ( matchSelectors[ 선택 ] ) {
							matchHandlers.push(handleObj);
						}
					}
					if (matchedHandlers.length) {
						handlerQueue.push( { elem: cur, handlers: matchHandlers } );
					}
				}
			}
		}

		// 나머지(직접 바인딩된) 핸들러를 추가합니다.
		현재 = 이것;
		if (delegateCount < handlers.length ) {
			handlerQueue.push( { elem: cur, handlers: handlers.slice( DelegateCount ) } );
		}

		핸들러큐를 반환합니다;
	},

	addProp: 함수( 이름, 후크 ) {
		Object.defineProperty( jQuery.Event.prototype, 이름, {
			열거 가능: 사실,
			구성 가능: 사실,

			get: isFunction( 후크 ) ?
				기능() {
					if ( this.originalEvent ) {
						반환 후크( this.originalEvent );
					}
				} :
				기능() {
					if ( this.originalEvent ) {
						return this.originalEvent[이름];
					}
				},

			설정: 함수( 값 ) {
				Object.defineProperty( this, 이름, {
					열거 가능: 사실,
					구성 가능: 사실,
					쓰기 가능: 사실,
					가치: 가치
				} );
			}
		} );
	},

	수정: 함수(originEvent) {
		return originalEvent[ jQuery.expando ] ?
			원본이벤트:
			새로운 jQuery.Event(originalEvent);
	},

	특별한: {
		짐: {

			// 트리거된 image.load 이벤트가 window.load로 버블링되는 것을 방지합니다.
			noBubble: 사실
		},
		클릭: {

			// 기본 이벤트를 활용하여 확인 가능한 입력의 올바른 상태를 확인합니다.
			설정: 함수( 데이터 ) {

				// _default와의 상호 압축성을 위해 `this` 액세스를 로컬 var로 바꿉니다.
				// `|| data`는 축소를 통해 변수를 보존하기 위한 데드 코드입니다.
				var el = 이것 || 데이터;

				// 첫 번째 핸들러를 요청합니다.
				if ( rcheckableType.test( el.type ) &&
					el.click && nodeName( el, "input" ) ) {

					// dataPriv.set( el, "클릭", ... )
					레버리지Native(el, "click", returnTrue );
				}

				// 호출자에서 정상적인 처리를 허용하려면 false를 반환합니다.
				거짓을 반환;
			},
			트리거: 함수( 데이터 ) {

				// _default와의 상호 압축성을 위해 `this` 액세스를 로컬 var로 바꿉니다.
				// `|| data`는 축소를 통해 변수를 보존하기 위한 데드 코드입니다.
				var el = 이것 || 데이터;

				// 클릭을 트리거하기 전에 강제 설정
				if ( rcheckableType.test( el.type ) &&
					el.click && nodeName( el, "input" ) ) {

					레버리지Native(el, "click" );
				}

				// 일반적인 이벤트 경로 전파를 허용하려면 false가 아닌 값을 반환합니다.
				사실을 반환;
			},

			// 브라우저 간 일관성을 위해 링크에서 기본 .click()을 억제합니다.
			// 현재 활용된 네이티브 이벤트 스택 안에 있는 경우에도 이를 방지합니다.
			_default: 함수( 이벤트 ) {
				var 대상 = 이벤트.대상;
				return rcheckableType.test( target.type ) &&
					target.click && nodeName( target, "input" ) &&
					dataPriv.get( target, "click" ) ||
					nodeName( 대상, "a" );
			}
		},

		언로드 전: {
			postDispatch: 함수( 이벤트 ) {

				// 지원: 파이어폭스 20+
				// returnValue 필드가 설정되지 않은 경우 Firefox는 경고하지 않습니다.
				if ( event.result !== 정의되지 않음 && event.originalEvent ) {
					event.originalEvent.returnValue = 이벤트.결과;
				}
			}
		}
	}
};

// 수동으로 트리거된 이벤트를 처리하는 이벤트 리스너가 있는지 확인합니다.
// 다음에 대한 응답으로 다시 호출될 때까지 진행을 중단하여 합성 이벤트
// 직접 실행되는 *네이티브* 이벤트로 상태 변경이
// 다른 리스너가 호출되기 전에 이미 발생했습니다.
함수leverageNative( el, type, ExpectSync ) {

	// ExpectSync 누락은 jQuery.event.add를 통해 강제로 설정해야 하는 트리거 호출을 나타냅니다.
	if ( !expectSync ) {
		if ( dataPriv.get( el, type ) === 정의되지 않음 ) {
			jQuery.event.add(el, type, returnTrue);
		}
		반품;
	}

	// 컨트롤러를 모든 이벤트 네임스페이스에 대한 특수 범용 핸들러로 등록합니다.
	dataPriv.set(el, type, false );
	jQuery.event.add(엘, 유형, {
		네임스페이스: 거짓,
		핸들러: 함수( 이벤트 ) {
			var notAsync, 결과,
				save = dataPriv.get( this, type );

			if ( ( event.isTrigger & 1 ) && this[ 유형 ] ) {

				// 외부 합성 .trigger() 이벤트 처리를 중단합니다.
				// 이러한 경우 저장된 데이터는 false여야 하지만 남은 캡처 개체일 수 있습니다.
				// 비동기 네이티브 핸들러(gh-4350)에서
				if ( !saved.length ) {

					// 내부 네이티브 이벤트를 처리할 때 사용할 인수를 저장합니다.
					// 항상 최소한 하나의 인수(이벤트 객체)가 있으므로 이 배열은
					// 남은 캡처 객체와 혼동되지 않습니다.
					저장된 = 슬라이스.콜(인수);
					dataPriv.set(this, 유형, 저장됨);

					// 기본 이벤트를 트리거하고 그 결과를 캡처합니다.
					// 지원: IE <=9 - 11+
					// focus()와 Blur()는 비동기적입니다.
					notAsync = ExpectSync( this, type );
					이 유형 ]();
					결과 = dataPriv.get( this, type );
					if ( 저장됨 !== 결과 || notAsync ) {
						dataPriv.set(this, type, false );
					} 또 다른 {
						결과 = {};
					}
					if ( 저장됨 !== 결과 ) {

						// 외부 합성 이벤트 취소
						event.stopImmediatePropagation();
						event.preventDefault();

						// 지원: 크롬 86+
						// Chrome에서 포커스아웃 핸들러가 있는 요소가 다음과 같이 흐려지면
						// 외부를 클릭하면 핸들러가 동기적으로 호출됩니다. 만약에
						// 해당 핸들러가 요소에 대해 `.remove()`를 호출하면 데이터가 지워집니다.
						// `결과`를 정의하지 않은 상태로 둡니다. 우리는 이것을 경계해야 합니다.
						결과 && 결과.값 반환;
					}

				// 버블링 서로게이트가 있는 이벤트에 대한 내부 합성 이벤트인 경우
				// (포커스 또는 흐림), 서로게이트가 이미 트리거에서 전파되었다고 가정합니다.
				// 기본 이벤트를 삭제하고 여기서 다시 발생하지 않도록 합니다.
				// 이는 기술적으로 `.trigger()`에 대한 잘못된 순서를 가져옵니다(여기서
				// 버블링 대리자는 버블링되지 않은 베이스 *이후*에 전파되지만, 그런 것 같습니다.
				// 복제보다 덜 나쁩니다.
				} else if ( ( jQuery.event.special[ 유형 ] || {} ).delegateType ) {
					event.stopPropagation();
				}

			// 위에서 트리거된 기본 이벤트인 경우 이제 모든 것이 정상입니다.
			// 원래 인수를 사용하여 내부 합성 이벤트를 발생시킵니다.
			} else if ( 저장된.길이 ) {

				// ...결과를 캡처합니다.
				dataPriv.set( this, 유형, {
					값: jQuery.event.trigger(

						// 지원: IE <=9 - 11+
						// 프로토타입으로 확장하여 위의 stopImmediatePropagation()을 재설정합니다.
						jQuery.extend( 저장됨[ 0 ], jQuery.Event.prototype ),
						저장된.슬라이스( 1 ),
						이것
					)
				} );

				// 네이티브 이벤트 처리 중단
				event.stopImmediatePropagation();
			}
		}
	} );
}

jQuery.removeEvent = function( elem, 유형, 핸들 ) {

	// 이 "if"는 일반 객체에 필요합니다.
	if( elem.removeEventListener ) {
		elem.removeEventListener( 유형, 핸들 );
	}
};

jQuery.Event = 함수( src, props ) {

	// 'new' 키워드 없이 인스턴스화를 허용합니다.
	if ( !( 이 jQuery.Event 인스턴스 ) ) {
		새로운 jQuery.Event( src, props )를 반환합니다.
	}

	// 이벤트 객체
	if (src && src.type) {
		this.originalEvent = src;
		this.type = src.type;

		// 문서에 버블링되는 이벤트가 방지된 것으로 표시되었을 수 있습니다.
		// 핸들러에 의해 트리 아래로 내려갑니다. 정확한 값을 반영합니다.
		this.isDefaultPrevented = src.defaultPrevented ||
				src.defaultPrevented === 정의되지 않음 &&

				// 지원: Android <=2.3 전용
				src.returnValue === 거짓 ?
			returnTrue :
			returnFalse;

		// 대상 속성 생성
		// 지원: Safari <=6 - 7만 해당
		// 대상은 텍스트 노드가 아니어야 합니다(#504, #13143).
		this.target = ( src.target && src.target.nodeType === 3 ) ?
			src.target.parentNode :
			src.대상;

		this.currentTarget = src.currentTarget;
		this.관련Target = src.관련Target;

	// 이벤트 유형
	} 또 다른 {
		this.type = src;
	}

	// 명시적으로 제공된 속성을 이벤트 객체에 넣습니다.
	if (소품) {
		jQuery.extend(this, props);
	}

	// 들어오는 이벤트에 타임스탬프가 없으면 타임스탬프를 만듭니다.
	this.timeStamp = src && src.timeStamp || Date.now();

	// 수정된 것으로 표시
	this[ jQuery.expando ] = true;
};

// jQuery.Event는 ECMAScript 언어 바인딩에 지정된 DOM3 이벤트를 기반으로 합니다.
// https://www.w3.org/TR/2003/WD-DOM-Level-3-Events-20030331/ecma-script-binding.html
jQuery.Event.prototype = {
	생성자: jQuery.Event,
	isDefaultPrevented: returnFalse,
	isPropagationStopped: returnFalse,
	isImmediatePropagationStopped: returnFalse,
	isSimulated: 거짓,

	PreventDefault: 함수() {
		var e = this.originalEvent;

		this.isDefaultPrevented = returnTrue;

		if ( e && !this.isSimulated ) {
			e.preventDefault();
		}
	},
	stopPropagation: 함수() {
		var e = this.originalEvent;

		this.isPropagationStopped = returnTrue;

		if ( e && !this.isSimulated ) {
			e.stopPropagation();
		}
	},
	stopImmediatePropagation: 함수() {
		var e = this.originalEvent;

		this.isImmediatePropagationStopped = returnTrue;

		if ( e && !this.isSimulated ) {
			e.stopImmediatePropagation();
		}

		this.stopPropagation();
	}
};

// KeyEvent 및 MouseEvent 특정 소품을 포함한 모든 일반 이벤트 소품을 포함합니다.
jQuery.each({
	altKey: 사실,
	거품: 사실,
	취소 가능: 사실,
	변경된 터치: true,
	Ctrl 키: 사실,
	세부정보: 사실,
	eventPhase: 사실,
	메타키: 사실,
	페이지X: 사실,
	pageY: 사실,
	ShiftKey: 사실,
	보기: 사실,
	"문자": 사실,
	코드: 사실,
	charCode: 참,
	키: 사실,
	키코드: 참,
	버튼: 사실,
	버튼: 사실,
	clientX: 사실,
	clientY: 사실,
	offsetX: 사실,
	offsetY: 사실,
	포인터 ID: true,
	포인터 유형: true,
	스크린X: 사실,
	screenY: 사실,
	targetTouches: 사실,
	toElement: 사실,
	접촉 : 사실,
	어느 것: 사실
}, jQuery.event.addProp );

jQuery.each( { 초점: "focusin", 흐림: "focusout" }, function( type, DelegateType ) {
	jQuery.event.special[ 유형 ] = {

		// 가능한 경우 기본 이벤트를 활용하여 흐림/초점 순서가 정확하도록 합니다.
		설정: 함수() {

			// 첫 번째 핸들러를 요청합니다.
			// dataPriv.set( this, "focus", ... )
			// dataPriv.set( this, "blur", ... )
			레버리지Native( this, type, ExpectSync );

			// 호출자에서 정상적인 처리를 허용하려면 false를 반환합니다.
			거짓을 반환;
		},
		트리거: 함수() {

			// 트리거 전 강제 설정
			레버리지Native( this, type );

			// 일반적인 이벤트 경로 전파를 허용하려면 false가 아닌 값을 반환합니다.
			사실을 반환;
		},

		// 이미 실행 중이므로 기본 초점 또는 흐림 효과를 억제합니다.
		// 레버리지Native.
		_default: 함수() {
			사실을 반환;
		},

		대리자 유형: 대리자 유형
	};
} );

// 마우스 오버/아웃 및 이벤트 시간 확인을 사용하여 마우스 입력/나가기 이벤트 생성
// 이벤트 위임이 jQuery에서 작동하도록 합니다.
// 포인터 입력/포인터리브 및 포인터 오버/포인터아웃에 대해 동일한 작업을 수행합니다.
//
// 지원: Safari 7만 해당
// Safari는 마우스 입력을 너무 자주 보냅니다. 보다:
// https://bugs.chromium.org/p/chromium/issues/detail?id=470258
// 버그 설명(이전 Chrome 버전에도 존재함)
jQuery.each({
	mouseenter: "마우스오버",
	mouseleave: "마우스아웃",
	포인터입력: "포인터오버",
	포인터리브: "포인터아웃"
}, 함수( 원본, 수정 ) {
	jQuery.event.special[ 원본 ] = {
		대리자 유형: 수정,
		바인딩 유형: 수정,

		핸들: 함수(이벤트) {
			바르 레트,
				대상=이것,
				관련 = event.관련Target,
				handlerObj = event.handleObj;

			// mouseenter/leave의 경우 관련 항목이 대상 외부에 있는 경우 핸들러를 호출합니다.
			// NB: 마우스가 브라우저 창에서 나가거나 들어간 경우 관련 타겟이 없습니다.
			if ( !관련 || ( 관련 !== 대상 && !jQuery.contains( 대상, 관련 ) ) ) {
				event.type=handleObj.origType;
				ret = handlerObj.handler.apply( this, 인수 );
				event.type = 수정;
			}
			반환 ret;
		}
	};
} );

jQuery.fn.extend({

	on: 함수( 유형, 선택기, 데이터, fn ) {
		반환(this, 유형, 선택기, 데이터, fn);
	},
	하나: 함수( 유형, 선택기, 데이터, fn ) {
		return on( this, 유형, 선택기, 데이터, fn, 1 );
	},
	off: 함수( 유형, 선택기, fn ) {
		var handlerObj, 유형;
		if ( 유형 && 유형.preventDefault && 유형.handleObj ) {

			// ( 이벤트 ) jQuery.Event를 전달했습니다.
			handlerObj = 유형.handleObj;
			jQuery( 유형.delegateTarget ).off(
				handlerObj.네임스페이스?
					handlerObj.origType + "." + handlerObj.namespace :
					handlerObj.origType,
				handlerObj.selector,
				handlerObj.handler
			);
			이거 돌려줘;
		}
		if ( 유형of 유형 === "객체" ) {

			// ( 유형-객체 [, 선택기] )
			for ( 유형을 입력하세요 ) {
				this.off( 유형, 선택기, 유형[ 유형 ] );
			}
			이거 돌려줘;
		}
		if ( 선택기 === false || 선택기 유형 === "함수" ) {

			// ( 유형 [, fn] )
			fn = 선택자;
			선택기 = 정의되지 않음;
		}
		if (fn === false ) {
			fn = returnFalse;
		}
		return this.each( function() {
			jQuery.event.remove(this, 유형, fn, 선택기);
		} );
	}
} );


var

	// 지원: IE <=10 - 11, Edge 12 - 13만 해당
	// IE/Edge에서 정규식 그룹을 사용하면 심각한 속도 저하가 발생합니다.
	// https://connect.microsoft.com/IE/feedback/details/1736512/ 참조
	rnoInnerhtml = /<script|<style|<link/i,

	// 확인됨="확인됨" 또는 확인됨
	rchecked = /checked\s*(?:[^=]|=\s*.checked.)/i,
	rcleanScript = /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g;

// 새 행을 포함하려면 상위 테이블보다 tbody를 선호합니다.
함수 조작Target( elem, content ) {
	if ( nodeName( elem, "table" ) &&
		nodeName( content.nodeType !== 11 ? content : content.firstChild, "tr" ) ) {

		return jQuery( elem ).children( "tbody" )[ 0 ] || 요소;
	}

	요소를 반환;
}

// 안전한 DOM 조작을 위해 스크립트 요소의 유형 속성을 대체/복원합니다.
함수 비활성화스크립트( elem ) {
	elem.type = ( elem.getAttribute( "type" ) !== null ) + "/" + elem.type;
	요소를 반환;
}
함수 복원스크립트( elem ) {
	if ( ( elem.type || "" ).slice( 0, 5 ) === "true/" ) {
		elem.type = elem.type.slice( 5 );
	} 또 다른 {
		elem.removeAttribute( "유형" );
	}

	요소를 반환;
}

함수 cloneCopyEvent( src, dest ) {
	var i, l, 유형, pdataOld, udataOld, udataCur, 이벤트;

	if ( dest.nodeType !== 1 ) {
		반품;
	}

	// 1. 개인 데이터 복사: 이벤트, 핸들러 등
	if ( dataPriv.hasData( src ) ) {
		pdataOld = dataPriv.get(src);
		이벤트 = pdataOld.events;

		if (이벤트) {
			dataPriv.remove( dest, "이벤트 처리" );

			for ( 이벤트 입력 ) {
				for ( i = 0, l = 이벤트[ 유형 ].length; i < l; i++ ) {
					jQuery.event.add( dest, type, events[ type ][ i ] );
				}
			}
		}
	}

	// 2. 사용자 데이터 복사
	if ( dataUser.hasData( src ) ) {
		udataOld = dataUser.access( src );
		udataCur = jQuery.extend( {}, udataOld );

		dataUser.set(dest, udataCur);
	}
}

// IE 버그 수정, 지원 테스트 참조
함수 fixInput(src, dest) {
	var nodeName = dest.nodeName.toLowerCase();

	// 복제된 체크박스 또는 라디오 버튼의 선택된 상태를 유지하는 데 실패합니다.
	if ( nodeName === "input" && rcheckableType.test( src.type ) ) {
		대상.checked = src.checked;

	// 옵션 복제 시 선택한 옵션을 기본 선택 상태로 되돌리는 데 실패합니다.
	} else if ( nodeName === "입력" || nodeName === "textarea" ) {
		dest.defaultValue = src.defaultValue;
	}
}

함수 domManip(컬렉션, 인수, 콜백, 무시됨) {

	// 중첩된 배열을 평면화합니다.
	args = flat(args);

	var 조각, 첫 번째, 스크립트, hasScripts, 노드, 문서,
		나는 = 0,
		l = 컬렉션.길이,
		iNoClone = 1 - 1,
		값 = 인수[ 0 ],
		valueIsFunction = isFunction(값);

	// WebKit에서는 확인된 노드 조각을 복제할 수 없습니다.
	if ( valueIsFunction ||
			( l > 1 && 값 유형 === "string" &&
				!support.checkClone && rchecked.test( value ) ) ) {
		return collection.each( function( index ) {
			var self = collection.eq(인덱스);
			if ( valueIsFunction ) {
				args[ 0 ] = value.call( this, index, self.html() );
			}
			domManip( self, args, 콜백, 무시됨 );
		} );
	}

	만약 (엘) {
		조각 = buildFragment( args, collection[ 0 ].ownerDocument, false, collection, 무시됨 );
		첫 번째 = 조각.firstChild;

		if (fragment.childNodes.length === 1) {
			조각 = 첫 번째;
		}

		// 콜백을 호출하려면 새로운 콘텐츠나 무시된 요소에 대한 관심이 필요합니다.
		if (첫 번째 || 무시됨) {
			scripts = jQuery.map( getAll(fragment, "script" ), 비활성화Script );
			hasScripts = scripts.length;

			// 마지막 항목에 원본 조각을 사용합니다.
			// 끝날 수 있으므로 첫 번째 대신
			// 특정 상황에서 잘못 비워지는 경우(#8070)
			for ( ; i < l; i++ ) {
				노드 = 조각;

				if ( i !== iNoClone ) {
					node = jQuery.clone( node, true, true );

					// 나중에 복원할 수 있도록 복제된 스크립트에 대한 참조를 유지합니다.
					if ( hasScripts ) {

						// 지원: Android <=4.0 전용, PhantomJS 1 전용
						// push.apply(_, arraylike)는 고대 WebKit에서 발생합니다.
						jQuery.merge( scripts, getAll( node, "script" ) );
					}
				}

				callback.call( collection[ i ], node, i );
			}

			if ( hasScripts ) {
				doc = 스크립트[ scripts.length - 1 ].ownerDocument;

				// 스크립트를 다시 활성화합니다.
				jQuery.map(스크립트,restoreScript);

				// 첫 번째 문서 삽입 시 실행 가능한 스크립트를 평가합니다.
				for ( i = 0; i < hasScripts; i++ ) {
					노드 = 스크립트[ i ];
					if ( rscriptType.test( node.type || "" ) &&
						!dataPriv.access( node, "globalEval" ) &&
						jQuery.contains( doc, node ) ) {

						if ( node.src && ( node.type || "" ).toLowerCase() !== "모듈" ) {

							// 선택적 AJAX 종속성이지만 존재하지 않으면 스크립트를 실행하지 않습니다.
							if ( jQuery._evalUrl && !node.noModule ) {
								jQuery._evalUrl( node.src, {
									nonce: node.nonce || node.getAttribute( "nonce" )
								}, 문서 );
							}
						} 또 다른 {
							DOMeval( node.textContent.replace( rcleanScript, "" ), node, doc );
						}
					}
				}
			}
		}
	}

	반품수거;
}

함수 제거( elem, 선택기, keepData ) {
	var 노드,
		노드 = 선택자 ? jQuery.filter( 선택기, elem ) : elem,
		나는 = 0;

	for ( ; ( 노드 = 노드[ i ] ) != null; i++ ) {
		if ( !keepData && node.nodeType === 1 ) {
			jQuery.cleanData( getAll( 노드 ) );
		}

		if ( node.parentNode ) {
			if ( keepData && isAttached( 노드 ) ) {
				setGlobalEval( getAll( node, "script" ) );
			}
			node.parentNode.removeChild(노드);
		}
	}

	요소를 반환;
}

jQuery.확장({
	htmlPrefilter: 함수( html ) {
		HTML을 반환;
	},

	클론: 함수( elem, dataAndEvents, deepDataAndEvents ) {
		var i, l, srcElements, destElements,
			클론 = elem.cloneNode( true ),
			inPage = isAttached( elem );

		// IE 복제 문제 수정
		if ( !support.noCloneChecked && ( elem.nodeType === 1 || elem.nodeType === 11 ) &&
				!jQuery.isXMLDoc( elem ) ) {

			// 여기서는 성능상의 이유로 Sizzle을 사용하지 않습니다: https://jsperf.com/getall-vs-sizzle/2
			destElements = getAll(클론);
			srcElements = getAll( elem );

			for ( i = 0, l = srcElements.length; i < l; i++ ) {
				fixInput( srcElements[ i ], destElements[ i ] );
			}
		}

		// 원본의 이벤트를 복제본으로 복사합니다.
		if ( 데이터앤이벤트 ) {
			if ( deepDataAndEvents ) {
				srcElements = srcElements || getAll(요소);
				destElements = destElements || getAll(클론);

				for ( i = 0, l = srcElements.length; i < l; i++ ) {
					cloneCopyEvent( srcElements[ i ], destElements[ i ] );
				}
			} 또 다른 {
				cloneCopyEvent( elem, clone );
			}
		}

		// 스크립트 평가 기록을 유지합니다.
		destElements = getAll( clone, "script" );
		if ( destElements.length > 0 ) {
			setGlobalEval( destElements, !inPage && getAll( elem, "script" ) );
		}

		// 복제된 세트를 반환합니다.
		클론 반환;
	},

	cleanData: 함수( 요소 ) {
		var 데이터, 요소, 유형,
			특수 = jQuery.event.special,
			나는 = 0;

		for ( ; ( elem = elems[ i ] ) !== 정의되지 않음; i++ ) {
			if ( acceptData( elem ) ) {
				if ( ( 데이터 = elem[ dataPriv.expando ] ) ) {
					if (데이터.이벤트) {
						for ( data.events 입력 ) {
							if ( 특수[ 유형 ] ) {
								jQuery.event.remove( elem, type );

							// jQuery.event.remove의 오버헤드를 피하기 위한 지름길입니다.
							} 또 다른 {
								jQuery.removeEvent( elem, type, data.handle );
							}
						}
					}

					// 지원: 크롬 <=35 - 45+
					// 삭제를 사용하는 대신 정의되지 않음을 할당합니다. Data#remo를 참조하세요.
					elem[ dataPriv.expando ] = 정의되지 않음;
				}
				if ( 요소[ dataUser.expando ] ) {

					// 지원: 크롬 <=35 - 45+
					// 삭제를 사용하는 대신 정의되지 않음을 할당합니다. Data#remo를 참조하세요.
					elem[ dataUser.expando ] = 정의되지 않음;
				}
			}
		}
	}
} );

jQuery.fn.extend({
	분리: 함수( 선택기 ) {
		return 제거( this, selector, true );
	},

	제거: 함수( 선택기 ) {
		return 제거( this, selector );
	},

	텍스트: 함수( 값 ) {
		return access( this, function( value ) {
			반환 값 === 정의되지 않음 ?
				jQuery.text( 이 ) :
				this.empty().each( function() {
					if ( this.nodeType === 1 || this.nodeType === 11 || this.nodeType === 9 ) {
						this.textContent = 값;
					}
				} );
		}, null, 값, 인수.길이 );
	},

	추가: 함수() {
		return domManip( this, 인수, function( elem ) {
			if ( this.nodeType === 1 || this.nodeType === 11 || this.nodeType === 9 ) {
				var target = 조작Target( this, elem );
				target.appendChild( elem );
			}
		} );
	},

	앞에 추가: function() {
		return domManip( this, 인수, function( elem ) {
			if ( this.nodeType === 1 || this.nodeType === 11 || this.nodeType === 9 ) {
				var target = 조작Target( this, elem );
				target.insertBefore( elem, target.firstChild );
			}
		} );
	},

	이전: 함수() {
		return domManip( this, 인수, function( elem ) {
			if ( this.parentNode ) {
				this.parentNode.insertBefore( elem, this );
			}
		} );
	},

	이후: 함수() {
		return domManip( this, 인수, function( elem ) {
			if ( this.parentNode ) {
				this.parentNode.insertBefore( elem, this.nextSibling );
			}
		} );
	},

	비어 있음: 함수() {
		변수 요소,
			나는 = 0;

		for ( ; ( elem = this[ i ] ) != null; i++ ) {
			if ( elem.nodeType === 1 ) {

				// 메모리 누수 방지
				jQuery.cleanData( getAll( elem, false ) );

				// 남은 노드를 모두 제거합니다.
				elem.textContent = "";
			}
		}

		이거 돌려줘;
	},

	클론: 함수( dataAndEvents, deepDataAndEvents ) {
		dataAndEvents = dataAndEvents == null ? 거짓 : dataAndEvents;
		deepDataAndEvents = deepDataAndEvents == null ? dataAndEvents : deepDataAndEvents;

		return this.map( function() {
			return jQuery.clone( this, dataAndEvents, deepDataAndEvents );
		} );
	},

	HTML: 함수(값) {
		return access( this, function( value ) {
			var elem = this[ 0 ] || {},
				나는 = 0,
				l = this.length;

			if ( 값 === 정의되지 않음 && elem.nodeType === 1 ) {
				elem.innerHTML을 반환합니다.
			}

			// 바로가기를 사용하여 innerHTML을 사용할 수 있는지 확인하세요.
			if ( typeof value === "string" && !rnoInnerhtml.test( value ) &&
				!wrapMap[ ( rtagName.exec( 값 ) || [ "", "" ] )[ 1 ].toLowerCase() ] ) {

				value = jQuery.htmlPrefilter( value );

				노력하다 {
					for ( ; i < l; i++ ) {
						elem = this[ i ] || {};

						// 요소 노드를 제거하고 메모리 누수를 방지합니다.
						if ( elem.nodeType === 1 ) {
							jQuery.cleanData( getAll( elem, false ) );
							elem.innerHTML = 값;
						}
					}

					요소 = 0;

				// innerHTML을 사용하면 예외가 발생하는 경우 fallback 메서드를 사용하세요.
				} 잡기 ( 전자 ) {}
			}

			if ( 요소 ) {
				this.empty().append(값);
			}
		}, null, 값, 인수.길이 );
	},

	교체: 함수() {
		var 무시 = [];

		// 무시되지 않은 각 컨텍스트 요소를 새 콘텐츠로 대체하여 변경합니다.
		return domManip( this, 인수, function( elem ) {
			var parent = this.parentNode;

			if ( jQuery.inArray( this, 무시됨 ) < 0 ) {
				jQuery.cleanData( getAll( this ) );
				if (부모) {
					parent.replaceChild( elem, this );
				}
			}

		// 강제 콜백 호출
		}, 무시됨 );
	}
} );

jQuery.each({
	추가: "추가",
	prependTo: "앞에 추가",
	insertBefore: "앞에",
	insertAfter: "이후",
	replacementAll: "replaceWith"
}, 함수( 이름, 원본 ) {
	jQuery.fn[ 이름 ] = 함수( 선택기 ) {
		변수 요소,
			ret = [],
			삽입 = jQuery(선택기),
			마지막 = insert.length - 1,
			나는 = 0;

		for ( ; i <= 마지막; i++ ) {
			elems = i === 마지막 ? this : this.clone( true );
			jQuery( insert[ i ] )[ 원본 ]( elems );

			// 지원: Android <=4.0 전용, PhantomJS 1 전용
			// .get() 왜냐하면 push.apply(_, arraylike)는 고대 WebKit에서 발생하기 때문입니다.
			push.apply( ret, elems.get() );
		}

		return this.pushStack( ret );
	};
} );
var rnumnonpx = new RegExp( "^(" + pnum + ")(?!px)[az%]+$", "i" );

var getStyles = function( elem ) {

		// 지원: IE <=11만, Firefox <=30 (#15098, #14150)
		// IE는 팝업에서 생성된 요소를 던집니다.
		// FF는 "defaultView.getCompulatedStyle"을 통해 프레임 요소를 발생시킵니다.
		var view = elem.ownerDocument.defaultView;

		if ( !view || !view.opener ) {
			보기 = 창;
		}

		return view.getCompulatedStyle( elem );
	};

var swap = function( elem, 옵션, 콜백 ) {
	var ret, 이름,
		오래된 = {};

	// 이전 값을 기억하고 새 값을 삽입합니다.
	for ( 옵션의 이름 ) {
		old[ 이름 ] = elem.style[ 이름 ];
		elem.style[ 이름 ] = 옵션[ 이름 ];
	}

	ret = callback.call( elem );

	// 이전 값을 되돌립니다.
	for ( 옵션의 이름 ) {
		elem.style[ 이름 ] = old[ 이름 ];
	}

	반환 ret;
};


var rboxStyle = new RegExp( cssExpand.join( "|" ), "i" );



( 기능() {

	// pixelPosition 및 boxSizingReliable 테스트를 모두 실행하려면 하나의 레이아웃만 필요합니다.
	// 두 번째 계산을 저장하기 위해 동시에 실행됩니다.
	함수 계산스타일테스트() {

		// 이것은 싱글톤이므로 한 번만 실행하면 됩니다.
		만약 ( !div ) {
			반품;
		}

		Container.style.cssText = "위치:절대;왼쪽:-11111px;너비:60px;" +
			"여백 상단:1px;패딩:0;테두리:0";
		div.style.cssText =
			"위치:상대;디스플레이:블록;상자 크기 조정:테두리 상자;오버플로:스크롤;" +
			"여백:자동;테두리:1px;패딩:1px;" +
			"너비:60%;상단:1%";
		documentElement.appendChild(컨테이너).appendChild(div);

		var divStyle = window.getCompulatedStyle(div);
		pixelPositionVal = divStyle.top !== "1%";

		// 지원: Android 4.0 - 4.3 전용, Firefox <=3 - 44
		ReliableMarginLeftVal = roundPixelMeasures( divStyle.marginLeft ) === 12;

		// 지원: Android 4.0 - 4.3 전용, Safari <=9.1 - 10.1, iOS <=7.0 - 9.3
		// 일부 스타일은 백분율 값이 반환되어서는 안 되지만 백분율 값으로 반환됩니다.
		div.style.right = "60%";
		pixelBoxStylesVal = roundPixelMeasures( divStyle.right ) === 36;

		// 지원: IE 9 - 11만 해당
		// box-sizing:border-box 요소에 대한 콘텐츠 크기의 잘못된 보고를 감지합니다.
		boxSizingReliableVal = roundPixelMeasures( divStyle.width ) === 36;

		// 지원: IE 9만 해당
		// 오버플로 감지:스크롤 오류(gh-3699)
		// 지원: 크롬 <=64
		// 확대/축소가 offsetWidth에 영향을 미칠 때 속지 마세요(gh-4029)
		div.style.position = "절대";
		scrollboxSizeVal = roundPixelMeasures( div.offsetWidth / 3 ) === 12;

		documentElement.removeChild(컨테이너);

		// 메모리에 저장되지 않도록 div를 무효화하고
		// 이미 검사가 수행되었다는 표시이기도 합니다.
		div = null;
	}

	함수 roundPixelMeasures( 측정 ) {
		return Math.round(parseFloat(measure) );
	}

	var pixelPositionVal, boxSizingReliableVal, scrollboxSizeVal, pixelBoxStylesVal,
		ReliableTrDimensionsVal, ReliableMarginLeftVal,
		컨테이너 = document.createElement( "div" ),
		div = document.createElement( "div" );

	// 제한된(브라우저가 아닌) 환경에서는 일찍 종료됩니다.
	if ( !div.style ) {
		반품;
	}

	// 지원: IE <=9 - 11만 해당
	// 복제된 요소의 스타일은 복제된 소스 요소에 영향을 미칩니다. (#8908)
	div.style.BackgroundClip = "콘텐츠 상자";
	div.cloneNode( true ).style.BackgroundClip = "";
	support.clearCloneStyle = div.style.BackgroundClip === "콘텐츠 상자";

	jQuery.extend( 지원, {
		boxSizingReliable: 함수() {
			계산스타일테스트();
			boxSizingReliableVal을 반환합니다.
		},
		pixelBoxStyles: 함수() {
			계산스타일테스트();
			pixelBoxStylesVal을 반환합니다.
		},
		pixelPosition: 함수() {
			계산스타일테스트();
			pixelPositionVal을 반환합니다.
		},
		ReliableMarginLeft: 함수() {
			계산스타일테스트();
			신뢰할 수 있는MarginLeftVal을 반환합니다.
		},
		스크롤박스 크기: 함수() {
			계산스타일테스트();
			scrollboxSizeVal을 반환합니다.
		},

		// 지원: IE 9 - 11+, Edge 15 - 18+
		// IE/Edge는 너비/높이가 있는 테이블 행의 `getCompulatedStyle`을 잘못 보고합니다.
		// `offset*` 속성이 올바른 값을 보고하는 동안 CSS에서 설정됩니다.
		// IE 9의 동작은 최신 버전보다 더 미묘하며 통과합니다.
		// 이 테스트의 일부 버전; 그곳을 통과하지 않도록 하세요!
		//
		// 지원: 파이어폭스 70+
		// Firefox에만 테두리 너비가 포함됩니다.
		// 계산된 차원에서. (gh-4529)
		ReliableTrDimensions: function() {
			var 테이블, tr, trChild, trStyle;
			if ( ReliableTrDimensionsVal == null ) {
				table = document.createElement( "테이블" );
				tr = document.createElement( "tr" );
				trChild = document.createElement( "div" );

				table.style.cssText = "위치:절대;왼쪽:-11111px;테두리 축소:별도";
				tr.style.cssText = "테두리:1px 실선";

				// 지원: 크롬 86+
				// cssText를 통해 설정된 높이가 적용되지 않습니다.
				// 계산된 높이는 0으로 돌아옵니다.
				tr.style.height = "1px";
				trChild.style.height = "9px";

				// 지원: 안드로이드 8 크롬 86+
				// bodyBackground.html iframe에서
				// 모든 div 요소에 대한 표시가 "인라인"으로 설정됩니다.
				// Android 8 Chrome 86에서만 문제가 발생합니다.
				// div가 표시되는지 확인: 블록
				// 이 문제를 해결합니다.
				trChild.style.display = "차단";

				문서요소
					.appendChild(테이블)
					.appendChild(tr)
					.appendChild(trChild);

				trStyle = window.getCompulatedStyle( tr );
				ReliableTrDimensionsVal = (parseInt(trStyle.height, 10) +
					parsInt( trStyle.borderTopWidth, 10 ) +
					ParseInt( trStyle.borderBottomWidth, 10 ) ) === tr.offsetHeight;

				documentElement.removeChild(테이블);
			}
			ReliableTrDimensionsVal을 반환합니다.
		}
	} );
} )();


function curCSS( 요소, 이름, 계산됨 ) {
	가변 너비, minWidth, maxWidth, ret,

		// 지원: 파이어폭스 51+
		// 어떻게든 계산되기 전에 스타일을 검색합니다.
		// 잘못된 값을 얻는 문제를 해결합니다.
		// 분리된 요소에 대해
		스타일 = elem.style;

	계산됨 = 계산됨 || getStyles(요소);

	// getPropertyValue는 다음에 필요합니다.
	// .css('filter') (IE 9만 해당, #12537)
	// .css('--customProperty) (#3144)
	if (계산됨) {
		ret = 계산.getPropertyValue( 이름 ) || 계산됨[ 이름 ];

		if ( ret === "" && !isAttached( elem ) ) {
			ret = jQuery.style( elem, 이름 );
		}

		// "Dean Edwards의 멋진 해킹"에 대한 찬사
		// Android 브라우저는 일부 값에 대한 백분율을 반환합니다.
		// 하지만 너비는 안정적으로 픽셀인 것 같습니다.
		// 이는 CSSOM 초안 사양에 위배됩니다.
		// https://drafts.csswg.org/cssom/#resolved-values
		if ( !support.pixelBoxStyles() && rnumnonpx.test( ret ) && rboxStyle.test( 이름 ) ) {

			// 원래 값을 기억합니다.
			너비 = 스타일.폭;
			minWidth = 스타일.minWidth;
			maxWidth = 스타일.maxWidth;

			// 계산된 값을 얻기 위해 새 값을 입력합니다.
			style.minWidth = style.maxWidth = style.width = ret;
			ret = 계산된 너비;

			// 변경된 값을 되돌립니다.
			스타일.폭 = 폭;
			style.minWidth = minWidth;
			style.maxWidth = 최대폭;
		}
	}

	return ret !== 정의되지 않음 ?

		// 지원: IE <=9 - 11만 해당
		// IE는 zIndex 값을 정수로 반환합니다.
		ret + "" :
		퇴장;
}


함수 addGetHookIf( ConditionFn, HookFn ) {

	// 후크를 정의합니다. 실제로 필요한지 첫 번째 실행에서 확인합니다.
	반품 {
		가져오기: 함수() {
			if ( 조건Fn() ) {

				// Hook이 필요하지 않습니다. (혹은 Hook이 필요하지 않기 때문에 사용할 수 없습니다.
				// 종속성이 누락된 경우) 제거합니다.
				this.get을 삭제하세요.
				반품;
			}

			// 후크가 필요합니다. 지원 테스트가 다시 실행되지 않도록 다시 정의하십시오.
			return ( this.get = HookFn ).apply( this, 인수 );
		}
	};
}


var cssPrefixes = [ "Webkit", "Moz", "ms" ],
	빈스타일 = document.createElement( "div" ).style,
	VendorProps = {};

// 공급업체 접두사가 붙은 속성 또는 정의되지 않은 속성을 반환합니다.
함수 VendorPropName( 이름 ) {

	// 공급업체 접두사가 붙은 이름을 확인합니다.
	var capName = 이름[ 0 ].toUpperCase() + name.slice( 1 ),
		i = cssPrefixes.length;

	동안( i-- ) {
		이름 = cssPrefixes[ i ] + capName;
		if (emptyStyle의 이름) {
			이름 반환;
		}
	}
}

// 잠재적으로 매핑된 jQuery.cssProps 또는 공급업체 접두사 속성을 반환합니다.
함수 finalPropName( 이름 ) {
	var final = jQuery.cssProps[ 이름 ] || VendorProps[이름];

	if (최종) {
		최종 반환;
	}
	if (emptyStyle의 이름) {
		이름 반환;
	}
	return VendorProps[ 이름 ] = VendorPropName( 이름 ) || 이름;
}


var

	// 디스플레이가 없거나 테이블로 시작하는 경우 교체 가능
	// "table", "table-cell" 또는 "table-caption" 제외
	// 표시 값은 여기를 참조하세요: https://developer.mozilla.org/en-US/docs/CSS/display
	rdisplayswap = /^(none|table(?!-c[ea]).+)/,
	rcustomProp = /^--/,
	cssShow = { 위치: "절대", 가시성: "숨김", 표시: "차단" },
	cssNormalTransform = {
		문자 간격: "0",
		글꼴 무게: "400"
	};

함수 setPositiveNumber( _elem, 값, 빼기 ) {

	// 상대(+/-) 값이 이미 지정되었습니다.
	// 이 시점에서 정규화됨
	var match = rcssNum.exec(값);
	일치 항목을 반환합니까?

		// 정의되지 않은 "뺄셈"을 방지합니다(예: cssHooks에서와 같이 사용되는 경우).
		Math.max( 0, 일치[ 2 ] - ( 빼기 || 0 ) ) + ( 일치[ 3 ] || "px" ) :
		값;
}

함수 boxModelAdjustment( elem, 차원, 상자, isBorderBox, 스타일, 계산된Val ) {
	var i = 치수 === "너비" ? 1:0,
		추가 = 0,
		델타 = 0;

	// 조정이 필요하지 않을 수도 있습니다.
	if ( box === ( isBorderBox ? "테두리" : "콘텐츠" ) ) {
		0을 반환합니다.
	}

	for ( ; i < 4; i += 2 ) {

		// 두 상자 모델 모두 여백을 제외합니다.
		if ( 상자 === "여백" ) {
			delta += jQuery.css( elem, box + cssExpand[ i ], true, styles );
		}

		// 콘텐츠 상자를 가지고 여기에 오면 "패딩", "테두리" 또는 "마진"을 찾고 있습니다.
		if ( !isBorderBox ) {

			// 패딩 추가
			delta += jQuery.css( elem, "padding" + cssExpand[ i ], true, styles );

			// "테두리" 또는 "여백"의 경우 테두리를 추가합니다.
			if ( 상자 !== "패딩" ) {
				delta += jQuery.css( elem, "border" + cssExpand[ i ] + "Width", true, styles );

			// 하지만 그렇지 않은 경우에는 계속 추적합니다.
			} 또 다른 {
				extra += jQuery.css( elem, "border" + cssExpand[ i ] + "Width", true, styles );
			}

		// 테두리 상자(내용 + 패딩 + 테두리)가 있는 경우 "콘텐츠"를 찾거나
		// "패딩" 또는 "여백"
		} 또 다른 {

			// "content"의 경우 패딩을 뺍니다.
			if ( 상자 === "내용" ) {
				delta -= jQuery.css( elem, "padding" + cssExpand[ i ], true, styles );
			}

			// "content" 또는 "padding"의 경우 테두리를 뺍니다.
			if ( 상자 !== "여백" ) {
				delta -= jQuery.css( elem, "border" + cssExpand[ i ] + "Width", true, styles );
			}
		}
	}

	// ComputedVal을 제공하여 요청하면 긍정적인 콘텐츠 상자 스크롤 여백을 고려합니다.
	if ( !isBorderBox && ComputedVal >= 0 ) {

		// offsetWidth/offsetHeight는 콘텐츠, 패딩, 스크롤 여백 및 테두리의 반올림된 합계입니다.
		// 정수 스크롤 여백을 가정하고 나머지를 빼고 반올림합니다.
		델타 += Math.max( 0, Math.ceil(
			elem[ "offset" + 차원[ 0 ].toUpperCase() + 차원.slice( 1 ) ] -
			계산된 값 -
			델타 -
			추가의 -
			0.5

		// offsetWidth/offsetHeight를 알 수 없으면 콘텐츠 상자 스크롤 여백을 결정할 수 없습니다.
		// NaN(gh-3964)을 피하기 위해 명시적인 0을 사용합니다.
		) ) || 0;
	}

	델타 반환;
}

함수 getWidthOrHeight( elem, 차원, 추가 ) {

	// 계산된 스타일로 시작
	var 스타일 = getStyles( elem ),

		// 강제 리플로우를 방지하려면 필요한 경우에만 boxSizing을 가져옵니다(gh-4322).
		// 실제 값을 아는 데 필요하다는 것을 알 때까지 콘텐츠 상자를 가짜로 만듭니다.
		boxSizingNeeded = !support.boxSizingReliable() || 추가의,
		isBorderBox = boxSizingNeeded &&
			jQuery.css( elem, "boxSizing", false, styles ) === "border-box",
		valueIsBorderBox = isBorderBox,

		val = curCSS(요소, 차원, 스타일),
		offsetProp = "오프셋" + 차원[ 0 ].toUpperCase() + 차원.slice( 1 );

	// 지원: 파이어폭스 <=54
	// 혼란스러운 픽셀이 아닌 값이나 무지한 척하는 값을 적절하게 반환합니다.
	if ( rnumnonpx.test( val ) ) {
		만약 (!추가) {
			가치를 반환;
		}
		발 = "자동";
	}


	// 지원: IE 9 - 11만 해당
	// 상자 크기가 신뢰할 수 없는 경우 offsetWidth/offsetHeight를 사용합니다.
	// 이 경우 계산된 값은 border-box라고 신뢰할 수 있습니다.
	if ( ( !support.boxSizingReliable() && isBorderBox ||

		// 지원: IE 10 - 11+, Edge 15 - 18+
		// IE/Edge는 너비/높이가 있는 테이블 행의 `getCompulatedStyle`을 잘못 보고합니다.
		// `offset*` 속성이 올바른 값을 보고하는 동안 CSS에서 설정됩니다.
		// 흥미롭게도 IE 9에서는 이 문제가 발생하지 않는 경우도 있습니다.
		!support.reliableTrDimensions() && nodeName( elem, "tr" ) ||

		// 값이 "auto"인 경우 offsetWidth/offsetHeight로 대체됩니다.
		// 이는 명시적인 설정이 없는 인라인 요소에 대해 발생합니다(gh-3571).
		val === "자동" ||

		// 지원: Android <=4.1 - 4.3만 해당
		// 잘못 보고된 인라인 크기에도 offsetWidth/offsetHeight를 사용합니다(gh-3602).
		!parseFloat( val ) && jQuery.css( elem, "display", false, styles ) === "inline" ) &&

		// 요소가 표시되고 연결되어 있는지 확인하세요.
		elem.getClientRects().length ) {

		isBorderBox = jQuery.css( elem, "boxSizing", false, styles ) === "border-box";

		// 가능한 경우 offsetWidth/offsetHeight는 대략적인 테두리 상자 크기입니다.
		// 사용할 수 없는 경우(예: SVG) 신뢰할 수 없는 상자 크기를 가정하고
		// 콘텐츠 상자 차원으로 값을 검색했습니다.
		valueIsBorderBox = 요소의 offsetProp;
		if ( valueIsBorderBox ) {
			val = 요소[ offsetProp ];
		}
	}

	// ""를 정규화하고 자동
	val = parsFloat( val ) || 0;

	// 요소의 상자 모델에 맞게 조정
	반환 ( 발 +
		상자모델조정(
			요소,
			치수,
			추가 || ( isBorderBox ? "테두리" : "콘텐츠" ),
			valueIsBorderBox,
			스타일,

			// 스크롤 여백 계산을 요청하기 위해 현재 계산된 크기를 제공합니다(gh-3589)
			발
		)
	) + "px";
}

jQuery.확장({

	// 기본값을 재정의하기 위해 스타일 속성 후크를 추가합니다.
	// 스타일 속성을 가져오고 설정하는 동작
	CSSHook: {
		불투명도: {
			get: 함수( 요소, 계산됨) {
				if (계산됨) {

					// 우리는 항상 불투명도로부터 숫자를 얻어야 합니다
					var ret = curCSS( elem, "opacity" );
					return ret === "" ? "1" : 리트;
				}
			}
		}
	},

	// 단위가 없을 수도 있는 속성에 "px"를 자동으로 추가하지 마세요.
	CSS번호: {
		"animationIterationCount": 사실,
		"columnCount": 사실,
		"fillOpacity": 사실,
		"flexGrow": 사실,
		"flexShrink": 사실,
		"fontWeight": 사실,
		"gridArea": ​​사실,
		"gridColumn": 사실,
		"gridColumnEnd": 사실,
		"gridColumnStart": 사실,
		"gridRow": 사실,
		"gridRowEnd": 사실,
		"gridRowStart": 사실,
		"lineHeight": 사실,
		"불투명도": 사실,
		"주문": 사실,
		"고아": 사실,
		"과부": 사실,
		"zIndex": 사실,
		"확대/축소": 사실
	},

	// 이전에 이름을 수정하려는 속성을 추가합니다.
	// 값을 설정하거나 가져오는 중
	CSSProps: {},

	// DOM 노드의 스타일 속성을 가져오고 설정합니다.
	스타일: 함수( elem, 이름, 값, 추가 ) {

		// 텍스트 및 주석 노드에 스타일을 설정하지 마세요.
		if ( !elem || elem.nodeType === 3 || elem.nodeType === 8 || !elem.style ) {
			반품;
		}

		// 올바른 이름으로 작업하고 있는지 확인하세요.
		var ret, 유형, 후크,
			origName = camelCase( 이름 ),
			isCustomProp = rcustomProp.test( 이름 ),
			스타일 = elem.style;

		// 올바른 이름으로 작업하고 있는지 확인하세요. 우리는하지 않습니다
		// CSS 사용자 정의 속성인 경우 값을 쿼리하고 싶습니다.
		// 사용자 정의이기 때문입니다.
		if ( !isCustomProp ) {
			이름 = finalPropName( origName );
		}

		// 접두사가 있는 버전에 대한 후크를 가져온 다음 접두사가 없는 버전에 대한 후크를 가져옵니다.
		Hooks = jQuery.cssHooks[ 이름 ] || jQuery.cssHooks[ origName ];

		// 값을 설정하고 있는지 확인
		if (값 !== 정의되지 않음) {
			유형 = 값 유형;

			// "+=" 또는 "-="를 상대 숫자로 변환합니다(#7345)
			if ( type === "string" && ( ret = rcssNum.exec( value ) ) && ret[ 1 ] ) {
				value = adjustCSS( elem, name, ret );

				// 버그 #9237 수정
				유형 = "번호";
			}

			// null 및 NaN 값이 설정되지 않았는지 확인하세요(#7116).
			if ( 값 == null || 값 !== 값 ) {
				반품;
			}

			// 숫자가 전달된 경우 단위를 추가합니다(특정 CSS 속성 제외).
			// 자동 추가만 할 경우 jQuery 4.0에서 isCustomProp 검사를 제거할 수 있습니다.
			// "px"를 몇 가지 하드코딩된 값으로 변환합니다.
			if ( type === "number" && !isCustomProp ) {
				값 += ret && ret[ 3 ] || ( jQuery.cssNumber[ origName ] ? "" : "px" );
			}

			// background-* 소품은 원본 복제본의 값에 영향을 미칩니다.
			if ( !support.clearCloneStyle && 값 === "" && name.indexOf( "배경" ) === 0 ) {
				스타일[ 이름 ] = "상속";
			}

			// 후크가 제공되면 해당 값을 사용하고, 그렇지 않으면 지정된 값을 설정합니다.
			if ( !hooks || !( 후크에 "설정" ) ||
				( value = Hooks.set( elem, value, extra ) ) !== 정의되지 않음 ) {

				if( isCustomProp ) {
					style.setProperty( 이름, 값 );
				} 또 다른 {
					스타일[ 이름 ] = 값;
				}
			}

		} 또 다른 {

			// 후크가 제공된 경우 거기에서 계산되지 않은 값을 가져옵니다.
			if ( 후크 && "get" 후크 &&
				( ret = Hooks.get( elem, false, extra ) ) !== 정의되지 않음 ) {

				반환 ret;
			}

			// 그렇지 않으면 스타일 객체에서 값을 가져옵니다.
			반환 스타일[이름];
		}
	},

	CSS: 함수( elem, 이름, 추가, 스타일 ) {
		var 발, 숫자, 후크,
			origName = camelCase( 이름 ),
			isCustomProp = rcustomProp.test( 이름 );

		// 올바른 이름으로 작업하고 있는지 확인하세요. 우리는하지 않습니다
		// CSS 사용자 정의 속성인 경우 값을 수정하고 싶습니다.
		// 사용자 정의이기 때문입니다.
		if ( !isCustomProp ) {
			이름 = finalPropName( origName );
		}

		// 접두사가 붙은 이름 뒤에 접두사가 없는 이름을 사용해 보세요.
		Hooks = jQuery.cssHooks[ 이름 ] || jQuery.cssHooks[ origName ];

		// 후크가 제공된 경우 거기에서 계산된 값을 가져옵니다.
		if ( 후크 && "get" in 후크 ) {
			val = Hooks.get( elem, true, extra );
		}

		// 그렇지 않고, 계산된 값을 얻을 수 있는 방법이 있으면 그 방법을 사용하세요.
		if (val === 정의되지 않음) {
			val = curCSS( 요소, 이름, 스타일 );
		}

		// "보통"을 계산된 값으로 변환
		if ( val === "normal" && cssNormalTransform의 이름 ) {
			val = cssNormalTransform[이름];
		}

		// 강제되거나 한정자가 제공되고 val이 숫자로 보이는 경우 숫자로 만듭니다.
		if (추가 === "" || 추가 ) {
			num=parseFloat(val);
			return extra === true || isFinite( 숫자 ) ? 숫자 || 0 : 발;
		}

		가치를 반환;
	}
} );

jQuery.each( [ "높이", "너비" ], function( _i, 차원 ) {
	jQuery.cssHooks[ 차원 ] = {
		get: 함수( elem, 계산, 추가 ) {
			if (계산됨) {

				// 특정 요소를 눈에 보이지 않게 표시하면 차원 정보를 가질 수 있습니다.
				// 하지만 이점을 얻을 수 있는 현재 표시 스타일이 있어야 합니다.
				return rdisplayswap.test( jQuery.css( elem, "display" ) ) &&

					// 지원: 사파리 8+
					// Safari의 테이블 열에는 0이 아닌 offsetWidth 및 0이 있습니다.
					// 표시가 변경되지 않는 한 getBoundingClientRect().width.
					// 지원: IE <=11만 해당
					// 연결이 끊긴 노드에서 getBoundingClientRect 실행
					// IE에서는 오류가 발생합니다.
					( !elem.getClientRects().length || !elem.getBoundingClientRect().width ) ?
					교환( elem, cssShow, function() {
						return getWidthOrHeight( elem, 차원, extra );
					} ) :
					getWidthOrHeight( 요소, 치수, 추가 );
			}
		},

		집합: 함수( elem, value, extra ) {
			var 일치,
				스타일 = getStyles( elem ),

				// 테스트가 실패할 가능성이 있는 경우에만 styles.position을 읽습니다.
				// 강제 리플로우를 방지합니다.
				scrollboxSizeBuggy = !support.scrollboxSize() &&
					styles.position === "절대",

				// 강제 리플로우를 방지하려면 필요한 경우에만 boxSizing을 가져옵니다(gh-3991).
				boxSizingNeeded = scrollboxSizeBuggy || 추가의,
				isBorderBox = boxSizingNeeded &&
					jQuery.css( elem, "boxSizing", false, styles ) === "border-box",
				빼기 = 추가 ?
					상자모델조정(
						요소,
						치수,
						추가의,
						isBorderBox,
						스타일
					) :
					0;

			// 오프셋*을 계산된 값과 비교하여 신뢰할 수 없는 테두리 상자 크기를 설명합니다.
			// 테두리와 패딩을 얻기 위해 콘텐츠 상자를 속입니다. (gh-3699)
			if ( isBorderBox && 스크롤박스SizeBuggy ) {
				빼기 -= Math.ceil(
					elem[ "offset" + 차원[ 0 ].toUpperCase() + 차원.slice( 1 ) ] -
					ParseFloat( 스타일[ 차원 ] ) -
					boxModelAdjustment( 요소, 차원, "테두리", false, 스타일 ) -
					0.5
				);
			}

			// 값 조정이 필요한 경우 픽셀로 변환
			if ( 빼기 && ( 일치 = rcssNum.exec( 값 ) ) &&
				( 일치[ 3 ] || "px" ) !== "px" ) {

				elem.style[ 차원 ] = 값;
				value = jQuery.css(요소, 차원);
			}

			return setPositiveNumber( elem, value, subtract );
		}
	};
} );

jQuery.cssHooks.marginLeft = addGetHookIf( support.reliableMarginLeft,
	함수(요소, 계산됨) {
		if (계산됨) {
			return (parseFloat( curCSS( elem, "marginLeft" ) ) ||
				elem.getBoundingClientRect().left -
					swap( elem, { marginLeft: 0 }, function() {
						return elem.getBoundingClientRect().left;
					} )
			) + "px";
		}
	}
);

// 이 후크는 애니메이션에서 속성을 확장하는 데 사용됩니다.
jQuery.each({
	여백: "",
	패딩: "",
	테두리: "너비"
}, 함수( 접두사, 접미사 ) {
	jQuery.cssHooks[ 접두사 + 접미사 ] = {
		확장: 함수(값) {
			변수 i = 0,
				확장 = {},

				// 문자열이 아닌 경우 단일 숫자로 가정합니다.
				부품 = 값 유형 === "문자열" ? value.split( " " ) : [ 값 ];

			for ( ; i < 4; i++ ) {
				확장[ 접두사 + cssExpand[ i ] + 접미사 ] =
					부품[ i ] || 부품[ i - 2 ] || 부품[ 0 ];
			}

			확장된 반환;
		}
	};

	if ( 접두사 !== "여백" ) {
		jQuery.cssHooks[ 접두사 + 접미사 ].set = setPositiveNumber;
	}
} );

jQuery.fn.extend({
	CSS: 함수( 이름, 값 ) {
		return access( this, function( elem, name, value ) {
			var 스타일, len,
				지도 = {},
				나는 = 0;

			if ( Array.isArray( 이름 ) ) {
				스타일 = getStyles( elem );
				len = 이름.길이;

				for ( ; i < len; i++ ) {
					map[ 이름[ i ] ] = jQuery.css( elem, 이름[ i ], false, 스타일 );
				}

				반환 지도;
			}

			반환 값 !== 정의되지 않음 ?
				jQuery.style( 요소, 이름, 값 ) :
				jQuery.css(요소, 이름);
		}, 이름, 값, 인수.길이 > 1 );
	}
} );


function Tween( elem, options, prop, end, easing ) {
	return new Tween.prototype.init( elem, options, prop, end, easing );
}
jQuery.Tween = 트윈;

Tween.prototype = {
	생성자: 트윈,
	init: function( elem, options, prop, end, easing, unit ) {
		this.elem = 요소;
		this.prop = 소품;
		this.easing = 완화 || jQuery.easing._default;
		this.options = 옵션;
		this.start = this.now = this.cur();
		this.end = 끝;
		this.unit = 단위 || ( jQuery.cssNumber[ prop ] ? "" : "px" );
	},
	현재: 함수() {
		var Hooks = Tween.propHooks[ this.prop ];

		리턴 후크 && Hooks.get ?
			Hooks.get( 이 ) :
			Tween.propHooks._default.get( this );
	},
	실행: 함수(퍼센트) {
		var 완화,
			후크 = Tween.propHooks[ this.prop ];

		if ( this.options.duration ) {
			this.pos = 완화 = jQuery.easing[ this.easing ](
				퍼센트, this.options.duration * 퍼센트, 0, 1, this.options.duration
			);
		} 또 다른 {
			this.pos = 완화됨 = 퍼센트;
		}
		this.now = ( this.end - this.start ) * 완화 + this.start;

		if ( this.options.step ) {
			this.options.step.call( this.elem, this.now, this );
		}

		if (후크 && Hooks.set) {
			Hooks.set( this );
		} 또 다른 {
			Tween.propHooks._default.set( this );
		}
		이거 돌려줘;
	}
};

Tween.prototype.init.prototype = Tween.prototype;

Tween.propHooks = {
	_기본: {
		get: 함수( 트윈 ) {
			var 결과;

			// DOM 요소가 아닌 경우 해당 요소의 속성을 직접 사용합니다.
			// 또는 일치하는 스타일 속성이 존재하지 않는 경우.
			if ( tween.elem.nodeType !== 1 ||
				tween.elem[ tween.prop ] != null && tween.elem.style[ tween.prop ] == null ) {
				return tween.elem[ tween.prop ];
			}

			// 빈 문자열을 .css의 세 번째 매개변수로 전달하면 자동으로
			//parseFloat를 시도하고 구문 분석이 실패하면 문자열로 대체합니다.
			// "10px"와 같은 간단한 값은 Float로 구문 분석됩니다.
			// "rotate(1rad)"와 같은 복잡한 값은 그대로 반환됩니다.
			결과 = jQuery.css( tween.elem, tween.prop, "" );

			// 빈 문자열, null, 정의되지 않음 및 "auto"는 0으로 변환됩니다.
			반환!결과 || 결과 === "자동" ? 0 : 결과;
		},
		설정: 함수( 트윈 ) {

			// 역호환을 위해 step Hook을 사용합니다.
			// cssHook이 있으면 사용하세요.
			// 가능한 경우 .style을 사용하고 가능한 경우 일반 속성을 사용합니다.
			if ( jQuery.fx.step[ tween.prop ] ) {
				jQuery.fx.step[ tween.prop ]( tween );
			} else if ( tween.elem.nodeType === 1 && (
				jQuery.cssHooks[ tween.prop ] ||
					tween.elem.style[ finalPropName( tween.prop ) ] != null ) ) {
				jQuery.style( tween.elem, tween.prop, tween.now + tween.unit );
			} 또 다른 {
				tween.elem[ tween.prop ] = tween.now;
			}
		}
	}
};

// 지원: IE <=9만 해당
// 연결이 끊긴 노드에 대한 설정에 대한 패닉 기반 접근 방식
Tween.propHooks.scrollTop = Tween.propHooks.scrollLeft = {
	설정: 함수( 트윈 ) {
		if ( tween.elem.nodeType && tween.elem.parentNode ) {
			tween.elem[ tween.prop ] = tween.now;
		}
	}
};

jQuery.easing = {
	선형: 함수( p ) {
		p를 반환;
	},
	스윙: 함수( p ) {
		0.5를 반환 - Math.cos( p * Math.PI ) / 2;
	},
	_default: "스윙"
};

jQuery.fx = Tween.prototype.init;

// 역호환 <1.8 확장점
jQuery.fx.step = {};




var
	fx지금 진행 중,
	rfxtypes = /^(?:toggle|show|hide)$/,
	rrun = /queueHooks$/;

함수 일정() {
	if (진행 중) {
		if ( document.hidden === false && window.requestAnimationFrame ) {
			window.requestAnimationFrame( 일정 );
		} 또 다른 {
			window.setTimeout( 일정, jQuery.fx.interval );
		}

		jQuery.fx.tick();
	}
}

// 동기적으로 생성된 애니메이션은 동기적으로 실행 됩니다.
함수 createFxNow() {
	window.setTimeout(함수() {
		fxNow = 정의되지 않음;
	} );
	return ( fxNow = Date.now() );
}

// 표준 애니메이션을 생성하기 위한 매개변수 생성
함수 genFx( 유형, includeWidth ) {
	var 어느,
		나는 = 0,
		attrs = { 높이: 유형 };

	// 너비를 포함하면 모든 cssExpand 값을 수행하는 단계 값은 1입니다.
	// 그렇지 않으면 단계 값은 2로 왼쪽과 오른쪽을 건너뜁니다.
	includeWidth = includeWidth ? 1:0;
	for ( ; i < 4; i += 2 - includeWidth ) {
		which = cssExpand[ i ];
		attrs[ "마진" + which ] = attrs[ "padding" + which ] = 유형;
	}

	if (includeWidth) {
		attrs.opacity = attrs.width = 유형;
	}

	반환 속성;
}

함수 createTween(값, 소품, 애니메이션) {
	가변 트윈,
		컬렉션 = ( Animation.tweeners[ prop ] || [] ).concat( Animation.tweeners[ "*" ] ),
		인덱스 = 0,
		길이 = 컬렉션.길이;
	for ( ; 인덱스 < 길이; 인덱스++ ) {
		if ( ( tween = collection[ index ].call( animation, prop, value ) ) ) {

			// 이 속성은 끝났습니다.
			트윈 반환;
		}
	}
}

function defaultPrefilter( elem, props, opts ) {
	var 소품, 값, 토글, 후크, oldfire, propTween, RestoreDisplay, 디스플레이,
		isBox = 소품의 "너비" || 소품의 "높이",
		애니=이것,
		원본 = {},
		스타일 = elem.style,
		숨겨진 = elem.nodeType && isHiddenWithinTree( elem ),
		dataShow = dataPriv.get( elem, "fxshow" );

	// 대기열 건너뛰기 애니메이션은 fx 후크를 탈취합니다.
	if ( !opts.queue ) {
		Hooks = jQuery._queueHooks( elem, "fx" );
		if (hooks.unqueued == null) {
			Hooks.unqueued = 0;
			oldfire = Hooks.empty.fire;
			Hooks.empty.fire = 함수() {
				if ( !hooks.unqueued ) {
					올드파이어();
				}
			};
		}
		Hooks.unqueued++;

		anim.always(함수() {

			// 완료되기 전에 전체 핸들러가 호출되는지 확인하세요.
			anim.always(함수() {
				후크.대기열 해제됨--;
				if ( !jQuery.queue( elem, "fx" ).length ) {
					Hooks.empty.fire();
				}
			} );
		} );
	}

	// 애니메이션 표시/숨기기 감지
	for ( 소품 속의 소품 ) {
		값 = 소품[ 소품 ];
		if ( rfxtypes.test( 값 ) ) {
			소품 삭제[prop ];
			토글 = 토글 || 값 === "토글";
			if ( value === ( 숨김 ? "hide" : "show" ) ) {

				// 이것이 "쇼"라면 숨겨진 척하고
				// 중지된 표시/숨기기의 데이터가 아직 남아 있습니다.
				if ( 값 === "표시" && dataShow && dataShow[ prop ] !== 정의되지 않음 ) {
					숨겨진 = 사실;

				// 다른 모든 무작동 표시/숨기기 데이터를 무시합니다.
				} 또 다른 {
					계속하다;
				}
			}
			orig[ prop ] = dataShow && dataShow[ prop ] || jQuery.style( elem, prop );
		}
	}

	// .hide().hide()와 같이 작동하지 않는 경우 구제합니다.
	propTween = !jQuery.isEmptyObject( props );
	if ( !propTween && jQuery.isEmptyObject( orig ) ) {
		반품;
	}

	// 상자 애니메이션 중 "오버플로" 및 "표시" 스타일을 제한합니다.
	if ( isBox && elem.nodeType === 1 ) {

		// 지원: IE <=9 - 11, 엣지 12 - 15
		// IE는 속기를 추론하지 않기 때문에 3개의 오버플로 속성을 모두 기록합니다.
		// 동일한 값의 OverflowX, OverflowY 및 Edge에서 미러링됩니다.
		// 거기에 OverflowX 값이 있습니다.
		opts.overflow = [ style.overflow, style.overflowX, style.overflowY ];

		// 디스플레이 유형을 식별하고 CSS 캐스케이드보다 이전 데이터 표시/숨기기를 선호합니다.
		RestoreDisplay = dataShow && dataShow.display;
		if (restoreDisplay == null) {
			RestoreDisplay = dataPriv.get( elem, "display" );
		}
		디스플레이 = jQuery.css( elem, "display" );
		if ( 표시 === "없음" ) {
			if ( 복원디스플레이 ) {
				디스플레이 = 복원디스플레이;
			} 또 다른 {

				// 일시적으로 가시성을 강제하여 비어 있지 않은 값을 얻습니다.
				showHide( [ elem ], true );
				RestoreDisplay = elem.style.display || 복원디스플레이;
				디스플레이 = jQuery.css( elem, "display" );
				showHide( [ 요소 ] );
			}
		}

		// 인라인 요소를 인라인 블록으로 애니메이션화합니다.
		if ( 디스플레이 === "인라인" || 디스플레이 === "인라인 블록" && RestoreDisplay != null ) {
			if ( jQuery.css( elem, "float" ) === "none" ) {

				// 순수 표시/숨기기 애니메이션이 끝나면 원래 표시 값을 복원합니다.
				if ( !propTween ) {
					anim.done(함수() {
						style.display = 복원디스플레이;
					} );
					if (restoreDisplay == null) {
						디스플레이 = 스타일.디스플레이;
						RestoreDisplay = 디스플레이 === "없음" ? "" : 표시하다;
					}
				}
				style.display = "인라인 블록";
			}
		}
	}

	if ( opts.overflow ) {
		style.overflow = "숨김";
		anim.always(함수() {
			style.overflow = opts.overflow[ 0 ];
			style.overflowX = opts.overflow[ 1 ];
			style.overflowY = opts.overflow[ 2 ];
		} );
	}

	// 애니메이션 표시/숨기기 구현
	propTween = 거짓;
	for ( 원본의 소품 ) {

		// 이 요소 애니메이션에 대한 일반 표시/숨기기 설정
		if ( !propTween ) {
			if ( 데이터쇼 ) {
				if ( dataShow 에 "숨김" ) {
					숨겨진 = dataShow.hidden;
				}
			} 또 다른 {
				dataShow = dataPriv.access( elem, "fxshow", { 디스플레이: RestoreDisplay } );
			}

			// 토글을 위해 숨김/표시를 저장하여 `.stop().toggle()`을 "반전"시킵니다.
			if (토글) {
				dataShow.hidden = !숨김;
			}

			// 애니메이션을 적용하기 전에 요소를 표시합니다.
			만약 (숨겨진) {
				showHide( [ elem ], true );
			}

			/* eslint-disable no-loop-func */

			anim.done(함수() {

				/* eslint-enable no-loop-func */

				// "숨기기" 애니메이션의 마지막 단계는 실제로 요소를 숨기는 것입니다.
				if ( !hidden ) {
					showHide( [ 요소 ] );
				}
				dataPriv.remove( elem, "fxshow" );
				for ( 원본의 소품 ) {
					jQuery.style( elem, prop, orig[ prop ] );
				}
			} );
		}

		// 속성별 설정
		propTween = createTween(hidden ? dataShow[ prop ] : 0, prop, anim );
		if ( !( dataShow의 소품 ) ) {
			dataShow[ prop ] = propTween.start;
			만약 (숨겨진) {
				propTween.end = propTween.start;
				propTween.start = 0;
			}
		}
	}
}

함수 propFilter( props, SpecialEasing ) {
	var 인덱스, 이름, 완화, 값, 후크;

	// camelCase, SpecialEasing 및 확장 cssHook 패스
	for(소품의 인덱스) {
		이름 = camelCase(index);
		easing = 특수Easing[ 이름 ];
		값 = 소품[인덱스];
		if ( Array.isArray( 값 ) ) {
			완화 = 값[ 1 ];
			값 = 소품[ 인덱스 ] = 값[ 0 ];
		}

		if ( 색인 !== 이름 ) {
			소품[이름] = 값;
			소품 삭제[색인];
		}

		후크 = jQuery.cssHooks[ 이름 ];
		if ( 후크 && 후크에서 "확장" ) {
			값 = Hooks.expand(값);
			소품[이름] 삭제;

			// $.extend가 아닙니다. 기존 키를 덮어쓰지 않습니다.
			// 올바른 "이름"이 있으므로 '인덱스'를 재사용합니다.
			for(값의 인덱스) {
				if ( !( 소품의 인덱스 ) ) {
					소품[ 인덱스 ] = 값[ 인덱스 ];
					특수Easing[ index ] = 완화;
				}
			}
		} 또 다른 {
			특수Easing[ 이름 ] = 완화;
		}
	}
}

함수 애니메이션(요소, 속성, 옵션) {
	var 결과,
		중지,
		인덱스 = 0,
		길이 = Animation.prefilters.length,
		deferred = jQuery.Deferred().always( function() {

			// :animated 선택기의 요소와 일치하지 않습니다.
			틱.엘렘 삭제;
		} ),
		틱 = 함수() {
			if (중지됨) {
				거짓을 반환;
			}
			var currentTime = fxNow || createFxNow(),
				남은 = Math.max(0, animation.startTime + animation.duration - currentTime ),

				// 지원: Android 2.3 전용
				// 오래된 충돌 버그로 인해 `1 - ( 0.5 || 0 )` 사용이 허용되지 않습니다. (#12497)
				온도 = 남은 시간 / animation.duration || 0,
				퍼센트 = 1 - 온도,
				인덱스 = 0,
				길이 = animation.tweens.length;

			for ( ; 인덱스 < 길이; 인덱스++ ) {
				animation.tweens[ 인덱스 ].run( 퍼센트 );
			}

			deferred.notifyWith( elem, [ 애니메이션, 백분율, 남은 ] );

			//더 할 일이 있으면 양보
			if (퍼센트 < 1 && 길이) {
				남은 금액을 반환합니다.
			}

			// 빈 애니메이션인 경우 최종 진행 알림을 합성합니다.
			if (!길이) {
				deferred.notifyWith( elem, [ animation, 1, 0 ] );
			}

			// 애니메이션을 해결하고 결론을 보고합니다.
			deferred.resolveWith( elem, [ animation ] );
			거짓을 반환;
		},
		애니메이션 = deferred.promise( {
			요소: 요소,
			소품: jQuery.extend({}, 속성),
			선택 사항: jQuery.extend( true, {
				특수 완화: {},
				완화: jQuery.easing._default
			}, 옵션 ),
			원본속성: 속성,
			원본옵션: 옵션,
			startTime: fxNow || createFxNow(),
			기간: 옵션.기간,
			트윈: [],
			createTween: 함수( prop, end ) {
				var tween = jQuery.Tween( elem, animation.opts, prop, end,
					animation.opts.specialEasing[ prop ] || animation.opts.easing );
				animation.tweens.push(트윈);
				트윈 반환;
			},
			중지: 함수( gotoEnd ) {
				변수 인덱스 = 0,

					// 끝까지 가려면 모든 트윈을 실행하고 싶습니다.
					// 그렇지 않으면 이 부분을 건너뜁니다.
					길이 = gotoEnd ? animation.tweens.length : 0;
				if (중지됨) {
					이거 돌려줘;
				}
				중지됨 = 사실;
				for ( ; 인덱스 < 길이; 인덱스++ ) {
					animation.tweens[ index ].run( 1 );
				}

				// 마지막 프레임을 재생했을 때 해결됩니다. 그렇지 않으면 거절하다
				if ( gotoEnd ) {
					deferred.notifyWith( elem, [ animation, 1, 0 ] );
					deferred.resolveWith( elem, [ animation, gotoEnd ] );
				} 또 다른 {
					deferred.rejectWith( elem, [ animation, gotoEnd ] );
				}
				이거 돌려줘;
			}
		} ),
		소품 = animation.props;

	propFilter(props, animation.opts.specialEasing);

	for ( ; 인덱스 < 길이; 인덱스++ ) {
		결과 = Animation.prefilters[ index ].call( animation, elem, props, animation.opts );
		만약 (결과) {
			if ( isFunction( result.stop ) ) {
				jQuery._queueHooks( animation.elem, animation.opts.queue ).stop =
					result.stop.bind( 결과 );
			}
			결과 반환;
		}
	}

	jQuery.map(props, createTween, animation);

	if ( isFunction( animation.opts.start ) ) {
		animation.opts.start.call( elem, animation );
	}

	// 옵션에서 콜백을 첨부합니다.
	생기
		.progress( animation.opts.progress )
		.done( animation.opts.done, animation.opts.complete )
		.fail( animation.opts.fail )
		.always( animation.opts.always );

	jQuery.fx.timer(
		jQuery.extend(틱, {
			요소: 요소,
			애니메이션: 애니메이션,
			대기열: animation.opts.queue
		} )
	);

	애니메이션 반환;
}

jQuery.Animation = jQuery.extend( 애니메이션, {

	트위너: {
		"*": [ 함수( 소품, 값 ) {
			var tween = this.createTween( prop, value );
			adjustCSS( tween.elem, prop, rcssNum.exec( value ), tween );
			트윈 반환;
		} ]
	},

	트위너: 함수(소품, 콜백) {
		if ( isFunction( 소품 ) ) {
			콜백 = 소품;
			소품 = [ "*" ];
		} 또 다른 {
			props = props.match(rnothtmlwhite);
		}

		var 소품,
			인덱스 = 0,
			길이 = props.length;

		for ( ; 인덱스 < 길이; 인덱스++ ) {
			소품 = 소품[인덱스];
			Animation.tweeners[ prop ] = Animation.tweeners[ prop ] || [];
			Animation.tweeners[ prop ].unshift( 콜백 );
		}
	},

	사전 필터: [ defaultPrefilter ],

	사전 필터: 함수(콜백, 앞에 추가) {
		if (앞에 추가) {
			Animation.prefilters.unshift( 콜백 );
		} 또 다른 {
			Animation.prefilters.push(콜백);
		}
	}
} );

jQuery.speed = function( 속도, 완화, fn ) {
	var opt = 속도 && 속도 유형 === "객체" ? jQuery.extend({}, 속도) : {
		완료: fn || !fn && 완화 ||
			isFunction( 속도 ) && 속도,
		기간: 속도,
		완화: fn && 완화 || 완화 && !isFunction( 완화 ) && 완화
	};

	// fx가 꺼져 있으면 종료 상태로 이동합니다.
	if (jQuery.fx.off) {
		opt.duration = 0;

	} 또 다른 {
		if ( opt.duration 유형 !== "숫자" ) {
			if (jQuery.fx.speeds의 opt.duration) {
				opt.duration = jQuery.fx.speeds[ opt.duration ];

			} 또 다른 {
				opt.duration = jQuery.fx.speeds._default;
			}
		}
	}

	// opt.queue 정규화 - true/정의되지 않음/null -> "fx"
	if ( opt.queue == null || opt.queue === true ) {
		opt.queue = "fx";
	}

	// 대기 중
	opt.old = 선택.완료;

	opt.complete = function() {
		if ( isFunction( opt.old ) ) {
			opt.old.call( this );
		}

		if ( opt.queue ) {
			jQuery.dequeue( this, opt.queue );
		}
	};

	반품 선택;
};

jQuery.fn.extend({
	fadeTo: 함수( 속도, 완화, 콜백 ) {

		// 불투명도를 0으로 설정한 후 숨겨진 요소를 표시합니다.
		return this.filter( isHiddenWithinTree ).css( "opacity", 0 ).show()

			// 지정된 값으로 애니메이션을 적용합니다.
			.end().animate( { opacity: to }, speed, easing, callback );
	},
	애니메이션: 함수( prop, speed, easing, callback ) {
		var 비어 있음 = jQuery.isEmptyObject(prop),
			optall = jQuery.speed( 속도, 완화, 콜백 ),
			doAnimation = 함수() {

				// 속성별 여유가 손실되지 않도록 prop의 복사본에 대해 작업합니다.
				var anim = Animation( this, jQuery.extend( {}, prop ), optall );

				// 빈 애니메이션 또는 종료가 즉시 해결됩니다.
				if ( 비어 있음 || dataPriv.get( this, "finish" ) ) {
					anim.stop( true );
				}
			};

		doAnimation.finish = doAnimation;

		빈 상태로 반환 || optall.queue === 거짓 ?
			this.each( doAnimation ) :
			this.queue( optall.queue, doAnimation );
	},
	중지: 함수( 유형, ClearQueue, gotoEnd ) {
		var stopQueue = function(후크) {
			var stop = Hooks.stop;
			Hooks.stop 삭제;
			중지( gotoEnd );
		};

		if ( 유형의 유형 !== "문자열" ) {
			gotoEnd = 클리어큐;
			클리어큐 = 유형;
			유형 = 정의되지 않음;
		}
		if (clearQueue) {
			this.queue( type || "fx", [] );
		}

		return this.each( function() {
			var dequeue = true,
				인덱스 = 유형 != null && 유형 + "queueHooks",
				타이머 = jQuery.timers,
				데이터 = dataPriv.get( this );

			if (색인) {
				if ( 데이터[ 인덱스 ] && 데이터[ 인덱스 ].stop ) {
					stopQueue( 데이터[ 인덱스 ] );
				}
			} 또 다른 {
				for(데이터의 인덱스) {
					if ( 데이터[ 인덱스 ] && 데이터[ 인덱스 ].stop && rrun.test( 인덱스 ) ) {
						stopQueue( 데이터[ 인덱스 ] );
					}
				}
			}

			for ( index = 타이머.길이; index--; ) {
				if ( 타이머[ index ].elem === this &&
					( 유형 == null || 타이머[ 인덱스 ].queue === 유형 ) ) {

					타이머[ index ].anim.stop( gotoEnd );
					대기열에서 빼기 = false;
					타이머.스플라이스(index, 1);
				}
			}

			// 마지막 단계가 강제 실행되지 않은 경우 대기열의 다음 단계를 시작합니다.
			// 타이머는 현재 전체 콜백을 호출합니다.
			// 대기열에서 제외되지만 gotoEnd인 경우에만 해당됩니다.
			if ( 대기열에서 제거 || !gotoEnd ) {
				jQuery.dequeue( this, type );
			}
		} );
	},
	마무리: 함수( 유형 ) {
		if ( 유형 !== false ) {
			유형 = 유형 || "FX";
		}
		return this.each( function() {
			변수 인덱스,
				데이터 = dataPriv.get( this ),
				대기열 = 데이터[ 유형 + "대기열" ],
				후크 = 데이터[ 유형 + "queueHooks" ],
				타이머 = jQuery.timers,
				길이 = 대기열? 대기열 길이 : 0;

			// 개인 데이터에 대한 종료 플래그를 활성화합니다.
			data.finish = true;

			// 먼저 대기열을 비웁니다.
			jQuery.queue( this, type, [] );

			if ( 후크 && Hooks.stop ) {
				Hooks.stop.call(this, true );
			}

			// 활성 애니메이션을 찾아 완료합니다.
			for ( index = 타이머.길이; index--; ) {
				if ( 타이머[ 인덱스 ].elem === 이 && 타이머[ 인덱스 ].queue === 유형 ) {
					타이머[ index ].anim.stop( true );
					타이머.스플라이스(index, 1);
				}
			}

			// 이전 대기열에서 애니메이션을 찾아 완료합니다.
			for ( 인덱스 = 0; 인덱스 < 길이; 인덱스++ ) {
				if ( 큐[ 인덱스 ] && 큐[ 인덱스 ].finish ) {
					대기열[ 색인 ].finish.call( this );
				}
			}

			// 종료 플래그 끄기
			데이터 삭제.완료;
		} );
	}
} );

jQuery.each( [ "toggle", "show", "hide" ], function( _i, name ) {
	var cssFn = jQuery.fn[이름];
	jQuery.fn[ 이름 ] = 함수( 속도, 완화, 콜백 ) {
		반환 속도 == null || 속도 유형 === "부울" ?
			cssFn.apply( this, 인수 ) :
			this.animate( genFx( 이름, true ), 속도, 완화, 콜백 );
	};
} );

// 사용자 정의 애니메이션에 대한 단축키 생성
jQuery.each({
	SlideDown: genFx( "표시" ),
	SlideUp: genFx( "hide" ),
	슬라이드토글: genFx( "토글" ),
	fadeIn: { 불투명도: "표시" },
	fadeOut: { 불투명도: "숨기기" },
	fadeToggle: { 불투명도: "토글" }
}, 함수( 이름, 소품 ) {
	jQuery.fn[ 이름 ] = 함수( 속도, 완화, 콜백 ) {
		return this.animate( props, speed, easing, callback );
	};
} );

jQuery.timers = [];
jQuery.fx.tick = 함수() {
	var 타이머,
		나는 = 0,
		타이머 = jQuery.timers;

	fxNow = Date.now();

	for ( ; i < 타이머.길이; i++ ) {
		타이머 = 타이머[ i ];

		// 타이머를 실행하고 완료되면 안전하게 제거합니다(외부 제거 가능).
		if ( !timer() && 타이머[ i ] === 타이머 ) {
			타이머.스플라이스( i--, 1 );
		}
	}

	if ( !timers.length ) {
		jQuery.fx.stop();
	}
	fxNow = 정의되지 않음;
};

jQuery.fx.timer = 함수( 타이머 ) {
	jQuery.timers.push( 타이머 );
	jQuery.fx.start();
};

jQuery.fx.interval = 13;
jQuery.fx.start = 함수() {
	if (진행 중) {
		반품;
	}

	진행 중 = true;
	일정();
};

jQuery.fx.stop = 함수() {
	진행 중 = null;
};

jQuery.fx.speeds = {
	느림: 600,
	빠른: 200,

	// 기본 속도
	_기본값: 400
};


// 허가를 받아 Clint Helfers의 플러그인을 기반으로 합니다.
// https://web.archive.org/web/20100324014747/http://blindsignals.com/index.php/2009/07/jquery-delay/
jQuery.fn.delay = 함수(시간, 유형) {
	시간 = jQuery.fx ? jQuery.fx.speeds[ 시간 ] || 시간 : 시간;
	유형 = 유형 || "FX";

	return this.queue( 유형, 함수( 다음, 후크 ) {
		var timeout = window.setTimeout(다음, 시간);
		Hooks.stop = function() {
			window.clearTimeout(timeout);
		};
	} );
};


( 기능() {
	var 입력 = document.createElement( "input" ),
		선택 = document.createElement( "선택" ),
		opt = select.appendChild( document.createElement( "option" ) );

	input.type = "체크박스";

	// 지원: Android <=4.3 전용
	// 체크박스의 기본값은 "on"이어야 합니다.
	support.checkOn = input.value !== "";

	// 지원: IE <=11만 해당
	// 기본 옵션을 선택하려면 selectedIndex에 액세스해야 합니다.
	support.optSelected = 선택.선택;

	// 지원: IE <=11만 해당
	// 입력이 라디오가 된 후 값을 잃습니다.
	input = document.createElement( "input" );
	input.value = "t";
	input.type = "라디오";
	support.radioValue = input.value === "t";
} )();


var boolHook,
	attrHandle = jQuery.expr.attrHandle;

jQuery.fn.extend({
	attr: 함수( 이름, 값 ) {
		반환 액세스(this, jQuery.attr, 이름, 값, 인수.길이 > 1);
	},

	RemoveAttr: 함수( 이름 ) {
		return this.each( function() {
			jQuery.removeAttr( this, name );
		} );
	}
} );

jQuery.확장({
	attr: 함수(요소, 이름, 값) {
		var ret, 후크,
			nType = elem.nodeType;

		// 텍스트, 주석 및 속성 노드의 속성을 가져오거나 설정하지 마세요.
		if ( nType === 3 || nType === 8 || nType === 2 ) {
			반품;
		}

		// 속성이 지원되지 않는 경우 prop으로 대체
		if ( typeof elem.getAttribute === "정의되지 않음" ) {
			return jQuery.prop( elem, 이름, 값 );
		}

		// 속성 후크는 소문자 버전에 따라 결정됩니다.
		// 정의된 후크가 있으면 필요한 후크를 가져옵니다.
		if ( nType !== 1 || !jQuery.isXMLDoc( elem ) ) {
			Hooks = jQuery.attrHooks[ name.toLowerCase() ] ||
				( jQuery.expr.match.bool.test( 이름 ) ? boolHook : 정의되지 않음 );
		}

		if (값 !== 정의되지 않음) {
			if (값 === null ) {
				jQuery.removeAttr( elem, name );
				반품;
			}

			if ( 후크 && "설정" 후크 &&
				( ret = Hooks.set( elem, value, name ) ) !== 정의되지 않음 ) {
				반환 ret;
			}

			elem.setAttribute( 이름, 값 + "" );
			반환값;
		}

		if ( 후크 && "get" 후크 && ( ret = Hooks.get( elem, name ) ) !== null ) {
			반환 ret;
		}

		ret = jQuery.find.attr( elem, 이름 );

		// 존재하지 않는 속성은 null을 반환하므로 정의되지 않은 것으로 정규화됩니다.
		ret == null을 반환합니까? 정의되지 않음: ret;
	},

	attrHook: {
		유형: {
			집합: 함수( elem, value ) {
				if ( !support.radioValue && 값 === "라디오" &&
					nodeName( elem, "input" ) ) {
					var val = elem.value;
					elem.setAttribute( "type", value );
					if ( 발 ) {
						elem.value = 발;
					}
					반환값;
				}
			}
		}
	},

	RemoveAttr: 함수( 요소, 값 ) {
		변수 이름,
			나는 = 0,

			// 속성 이름에는 HTML이 아닌 공백 문자가 포함될 수 있습니다.
			// https://html.spec.whatwg.org/multipage/syntax.html#attributes-2
			attrNames = value && value.match( rnothtmlwhite );

		if ( attrNames && elem.nodeType === 1 ) {
			while ( ( 이름 = attrNames[ i++ ] ) ) {
				elem.removeAttribute( 이름 );
			}
		}
	}
} );

// 부울 속성에 대한 후크
boolHook = {
	집합: 함수(요소, 값, 이름) {
		if ( 값 === false ) {

			// false로 설정된 경우 부울 속성을 제거합니다.
			jQuery.removeAttr( elem, name );
		} 또 다른 {
			elem.setAttribute( 이름, 이름 );
		}
		이름 반환;
	}
};

jQuery.each( jQuery.expr.match.bool.source.match( /\w+/g ), 함수( _i, 이름 ) {
	var getter = attrHandle[ 이름 ] || jQuery.find.attr;

	attrHandle[ 이름 ] = 함수( elem, 이름, isXML ) {
		var ret, 핸들,
			lowercaseName = 이름.toLowerCase();

		if ( !isXML ) {

			// getter에서 이 함수를 일시적으로 제거하여 무한 루프를 방지합니다.
			핸들 = attrHandle[ 소문자이름 ];
			attrHandle[ lowercaseName ] = ret;
			ret = getter( elem, name, isXML ) != null ?
				소문자이름:
				없는;
			attrHandle[ lowercaseName ] = 핸들;
		}
		반환 ret;
	};
} );




var rfocusable = /^(?:input|select|textarea|button)$/i,
	rclickable = /^(?:a|area)$/i;

jQuery.fn.extend({
	prop: 함수(이름, 값) {
		반환 액세스(this, jQuery.prop, 이름, 값, 인수.길이 > 1);
	},

	RemoveProp: 함수( 이름 ) {
		return this.each( function() {
			이것을 삭제하세요[ jQuery.propFix[ 이름 ] || 이름 ];
		} );
	}
} );

jQuery.확장({
	prop: 함수(요소, 이름, 값) {
		var ret, 후크,
			nType = elem.nodeType;

		// 텍스트, 주석 및 속성 노드에 대한 속성을 가져오거나 설정하지 마세요.
		if ( nType === 3 || nType === 8 || nType === 2 ) {
			반품;
		}

		if ( nType !== 1 || !jQuery.isXMLDoc( elem ) ) {

			// 이름 수정 및 후크 연결
			이름 = jQuery.propFix[ 이름 ] || 이름;
			Hooks = jQuery.propHooks[ 이름 ];
		}

		if (값 !== 정의되지 않음) {
			if ( 후크 && "설정" 후크 &&
				( ret = Hooks.set( elem, value, name ) ) !== 정의되지 않음 ) {
				반환 ret;
			}

			return ( elem[ 이름 ] = 값 );
		}

		if ( 후크 && "get" 후크 && ( ret = Hooks.get( elem, name ) ) !== null ) {
			반환 ret;
		}

		return 요소[이름];
	},

	propHook: {
		탭 인덱스: {
			get: 함수( elem ) {

				// 지원: IE <=9 - 11만 해당
				// elem.tabIndex가 항상 반환하지는 않습니다.
				// 명시적으로 설정되지 않은 경우 올바른 값
				// https://web.archive.org/web/20141116233347/http://fluidproject.org/blog/2008/01/09/getting-setting-and-removing-tabindex-values-with-javascript/
				// 적절한 속성 검색을 사용합니다(#12072)
				var tabindex = jQuery.find.attr( elem, "tabindex" );

				if (탭인덱스) {
					return parInt( tabindex, 10 );
				}

				만약에 (
					rfocusable.test( elem.nodeName ) ||
					rclickable.test( elem.nodeName ) &&
					elem.href
				) {
					0을 반환합니다.
				}

				-1을 반환합니다.
			}
		}
	},

	소품수정: {
		"for": "htmlFor",
		"클래스": "클래스이름"
	}
} );

// 지원: IE <=11만 해당
// selectedIndex 속성에 액세스
// 브라우저가 선택된 설정을 따르도록 강제합니다.
// 옵션에
// getter는 기본 옵션이 선택되었는지 확인합니다.
// optgroup에 있을 때
// 이 코드에서는 eslint 규칙 "no-unused-expressions"가 비활성화되었습니다.
// 그러한 접근을 고려하기 때문에 noop
if ( !support.optSelected ) {
	jQuery.propHooks.selected = {
		get: 함수( elem ) {

			/* eslint no-unused-expressions: "off" */

			var parent = elem.parentNode;
			if (부모 && parent.parentNode ) {
				parent.parentNode.selectedIndex;
			}
			null을 반환;
		},
		집합: 함수( elem ) {

			/* eslint no-unused-expressions: "off" */

			var parent = elem.parentNode;
			if (부모) {
				parent.selectedIndex;

				if ( parent.parentNode ) {
					parent.parentNode.selectedIndex;
				}
			}
		}
	};
}

jQuery.each( [
	"탭인덱스",
	"읽기 전용",
	"최대 길이",
	"셀 간격",
	"셀패딩",
	"행스팬",
	"콜스팬",
	"사용지도",
	"프레임테두리",
	"콘텐츠편집 가능"
], 기능() {
	jQuery.propFix[ this.toLowerCase() ] = this;
} );




	// HTML 사양에 따라 공백을 제거하고 축소합니다.
	// https://infra.spec.whatwg.org/#strip-and-collapse-ascii-whitespace
	함수 StripAndCollapse(값) {
		var 토큰 = value.match(rnothtmlwhite) || [];
		return tokens.join( " " );
	}


함수 getClass( elem ) {
	return elem.getAttribute && elem.getAttribute( "class" ) || "";
}

함수 클래스ToArray(값) {
	if ( Array.isArray( 값 ) ) {
		반환값;
	}
	if ( 값 유형 === "문자열" ) {
		return value.match( rnothtmlwhite ) || [];
	}
	반품 [];
}

jQuery.fn.extend({
	addClass: 함수(값) {
		var 클래스, elem, cur, curValue, clazz, j, finalValue,
			나는 = 0;

		if ( isFunction( 값 ) ) {
			return this.each( function( j ) {
				jQuery( this ).addClass( value.call( this, j, getClass( this ) ) );
			} );
		}

		클래스 = 클래스ToArray(값);

		if (classes.length) {
			while ( ( elem = this[ i++ ] ) ) {
				curValue = getClass( elem );
				cur = elem.nodeType === 1 && ( " " + StripAndCollapse( curValue ) + " " );

				만약 ( 현재 ) {
					j = 0;
					while ( ( clazz = 클래스[ j++ ] ) ) {
						if ( cur.indexOf( " " + clazz + " " ) < 0 ) {
							현재 += 클래즈 + " ";
						}
					}

					// 불필요한 렌더링을 피하기 위해 다른 경우에만 할당합니다.
					finalValue = StripAndCollapse( cur );
					if ( curValue !== 최종값 ) {
						elem.setAttribute( "class", finalValue );
					}
				}
			}
		}

		이거 돌려줘;
	},

	제거클래스: 함수(값) {
		var 클래스, elem, cur, curValue, clazz, j, finalValue,
			나는 = 0;

		if ( isFunction( 값 ) ) {
			return this.each( function( j ) {
				jQuery( this ).removeClass( value.call( this, j, getClass( this ) ) );
			} );
		}

		if ( !arguments.length ) {
			return this.attr( "class", "" );
		}

		클래스 = 클래스ToArray(값);

		if (classes.length) {
			while ( ( elem = this[ i++ ] ) ) {
				curValue = getClass( elem );

				// 이 표현식은 더 나은 압축성을 위해 여기에 있습니다(addClass 참조).
				cur = elem.nodeType === 1 && ( " " + StripAndCollapse( curValue ) + " " );

				만약 ( 현재 ) {
					j = 0;
					while ( ( clazz = 클래스[ j++ ] ) ) {

						// *모든* 인스턴스 제거
						while ( cur.indexOf( " " + clazz + " " ) > -1 ) {
							cur = cur.replace( " " + clazz + " ", " " );
						}
					}

					// 불필요한 렌더링을 피하기 위해 다른 경우에만 할당합니다.
					finalValue = StripAndCollapse( cur );
					if ( curValue !== 최종값 ) {
						elem.setAttribute( "class", finalValue );
					}
				}
			}
		}

		이거 돌려줘;
	},

	토글클래스: 함수( value, stateVal ) {
		var 유형 = 값 유형,
			isValidValue = 유형 === "문자열" || Array.isArray(값);

		if ( typeof stateVal === "boolean" && isValidValue ) {
			stateVal을 반환합니까? this.addClass(값) : this.removeClass(값);
		}

		if ( isFunction( 값 ) ) {
			return this.each( 함수( i ) {
				jQuery( this ).toggleClass(
					value.call( this, i, getClass( this ), stateVal ),
					stateVal
				);
			} );
		}

		return this.each( function() {
			var className, i, self, classNames;

			if ( isValidValue ) {

				// 개별 클래스 이름을 전환합니다.
				나는 = 0;
				self = jQuery( this );
				classNames = classToArray(값);

				while ( ( className = classNames[ i++ ] ) ) {

					// 주어진 각 className을 확인하고 공백으로 구분된 목록을 확인합니다.
					if ( self.hasClass( 클래스이름 ) ) {
						self.removeClass( className );
					} 또 다른 {
						self.addClass(클래스명);
					}
				}

			// 전체 클래스 이름을 토글합니다.
			} else if ( 값 === 정의되지 않음 || 유형 === "부울" ) {
				className = getClass( this );
				if (클래스이름) {

					// 설정된 경우 className을 저장합니다.
					dataPriv.set(this, "__className__", className );
				}

				// 요소에 클래스 이름이 있거나 `false`가 전달된 경우,
				// 그런 다음 전체 클래스 이름을 제거합니다(있는 경우 위의 방법으로 저장했습니다).
				// 그렇지 않으면 이전에 저장한 내용을 다시 가져옵니다(있는 경우).
				// 아무것도 저장되지 않은 경우 빈 문자열로 돌아갑니다.
				if ( this.setAttribute ) {
					this.setAttribute("클래스",
						클래스이름 || 값 === 거짓 ?
							"" :
							dataPriv.get( this, "__className__" ) || ""
					);
				}
			}
		} );
	},

	hasClass: 함수( 선택기 ) {
		var 클래스이름, 요소,
			나는 = 0;

		className = " " + 선택기 + " ";
		while ( ( elem = this[ i++ ] ) ) {
			if ( elem.nodeType === 1 &&
				( " " + StripAndCollapse( getClass( elem ) ) + " " ).indexOf( className ) > -1 ) {
				사실을 반환;
			}
		}

		거짓을 반환;
	}
} );




var rreturn = /\r/g;

jQuery.fn.extend({
	값: 함수( 값 ) {
		var 후크, ret, valueIsFunction,
			elem = this[ 0 ];

		if ( !arguments.length ) {
			if ( 요소 ) {
				Hooks = jQuery.valHooks[ elem.type ] ||
					jQuery.valHooks[ elem.nodeName.toLowerCase() ];

				if ( 후크 &&
					후크 &&에서 "get"
					( ret = Hooks.get( elem, "value" ) ) !== 정의되지 않음
				) {
					반환 ret;
				}

				ret = elem.value;

				// 가장 일반적인 문자열 케이스를 처리합니다.
				if ( ret 유형 === "문자열" ) {
					return ret.replace( rreturn, "" );
				}

				// 값이 null/undef 또는 숫자인 경우를 처리합니다.
				ret == null을 반환합니까? "" : 리트;
			}

			반품;
		}

		valueIsFunction = isFunction(값);

		return this.each( 함수( i ) {
			var 발;

			if ( this.nodeType !== 1 ) {
				반품;
			}

			if ( valueIsFunction ) {
				val = value.call( this, i, jQuery( this ).val() );
			} 또 다른 {
				발 = 값;
			}

			// null/undefine을 ""로 처리합니다. 숫자를 문자열로 변환
			if (val == null ) {
				발 = "";

			} else if ( typeof val === "숫자" ) {
				발 += "";

			} else if ( Array.isArray( val ) ) {
				val = jQuery.map( val, function( value ) {
					반환 값 == null ? "" : 값 + "";
				} );
			}

			Hooks = jQuery.valHooks[ this.type ] || jQuery.valHooks[ this.nodeName.toLowerCase() ];

			// 설정이 정의되지 않은 경우 일반 설정으로 돌아갑니다.
			if ( !hooks || !( 후크의 "설정" ) || Hooks.set( this, val, "value" ) === 정의되지 않음 ) {
				this.value = 발;
			}
		} );
	}
} );

jQuery.확장({
	ValHook: {
		옵션: {
			get: 함수( elem ) {

				var val = jQuery.find.attr( elem, "value" );
				반환 값 != null ?
					발 :

					// 지원: IE <=10 - 11만
					// option.text에서 예외가 발생합니다(#14686, #14858).
					// 공백을 제거하고 축소합니다.
					// https://html.spec.whatwg.org/#strip-and-collapse-whitespace
					StripAndCollapse( jQuery.text( elem ) );
			}
		},
		선택하다: {
			get: 함수( elem ) {
				var 값, 옵션, i,
					옵션 = elem.options,
					인덱스 = elem.selectedIndex,
					one = elem.type === "선택-1",
					값 = 1 ? 없는 : [],
					최대 = 1? 인덱스 + 1 : 옵션.길이;

				if (인덱스 < 0) {
					나는 = 최대;

				} 또 다른 {
					나 = 하나? 인덱스 : 0;
				}

				// 선택한 모든 옵션을 반복합니다.
				for ( ; i < 최대; i++ ) {
					옵션 = 옵션[ i ];

					// 지원: IE <=9만 해당
					// IE8-9는 양식 재설정 후 선택된 항목을 업데이트하지 않습니다. (#2551)
					if ( ( option.selected || i === index ) &&

							// 비활성화되었거나 비활성화된 optgroup에 있는 옵션을 반환하지 마세요.
							!옵션.비활성화 &&
							( !option.parentNode.disabled ||
								!nodeName( option.parentNode, "optgroup" ) ) ) {

						// 옵션의 특정 값을 가져옵니다.
						value = jQuery(옵션).val();

						// 하나의 선택에는 배열이 필요하지 않습니다.
						만약 ( 하나 ) {
							반환값;
						}

						// 다중 선택은 배열을 반환합니다.
						값.푸시(값);
					}
				}

				반환 값;
			},

			집합: 함수( elem, value ) {
				var optionSet, 옵션,
					옵션 = elem.options,
					값 = jQuery.makeArray(값),
					i = 옵션.길이;

				동안( i-- ) {
					옵션 = 옵션[ i ];

					/* eslint-disable 조건 없음-할당 */

					if (옵션.선택 =
						jQuery.inArray( jQuery.valHooks.option.get( 옵션 ), 값 ) > -1
					) {
						옵션셋 = true;
					}

					/* eslint-enable no-cond-Assign */
				}

				// 일치하지 않는 값이 설정된 경우 브라우저가 일관되게 작동하도록 강제합니다.
				if ( !optionSet ) {
					elem.selectedIndex = -1;
				}
				반환 값;
			}
		}
	}
} );

// 라디오 및 체크박스 getter/setter
jQuery.each( [ "radio", "checkbox" ], function() {
	jQuery.valHooks[ this ] = {
		집합: 함수( elem, value ) {
			if ( Array.isArray( 값 ) ) {
				return ( elem.checked = jQuery.inArray( jQuery( elem ).val(), value ) > -1 );
			}
		}
	};
	if ( !support.checkOn ) {
		jQuery.valHooks[ this ].get = function( elem ) {
			return elem.getAttribute( "value" ) === null ? "on": elem.value;
		};
	}
} );




// 속성만 포함하려면 jQuery를 반환합니다.


support.focusin = 창의 "onfocusin";


var rfocusMorph = /^(?:focusinfocus|focusoutblur)$/,
	stopPropagationCallback = 함수( e ) {
		e.stopPropagation();
	};

jQuery.extend(jQuery.event, {

	트리거: 함수(이벤트, 데이터, elem, onlyHandlers) {

		var i, cur, tmp, bubbleType, ontype, 핸들, 특수, lastElement,
			eventPath = [ 요소 || 문서 ],
			type = hasOwn.call( event, "type" ) ? event.type : 이벤트,
			네임스페이스 = hasOwn.call( event, "namespace" ) ? event.namespace.split( "." ) : [];

		cur = lastElement = tmp = elem = elem || 문서;

		// 텍스트 및 주석 노드에서는 이벤트를 수행하지 않습니다.
		if ( elem.nodeType === 3 || elem.nodeType === 8 ) {
			반품;
		}

		// 포커스/블러는 포커스 인/아웃으로 변경됩니다. 지금 당장 해고하지 않도록 하세요
		if ( rfocusMorph.test( type + jQuery.event.triggered ) ) {
			반품;
		}

		if ( type.indexOf( "." ) > -1 ) {

			// 네임스페이스 트리거; handler()의 이벤트 유형과 일치하는 정규식을 만듭니다.
			네임스페이스 = type.split( "." );
			유형 = 네임스페이스.shift();
			네임스페이스.정렬();
		}
		ontype = type.indexOf( ":" ) < 0 && "on" + type;

		// 호출자는 jQuery.Event 객체, 객체 또는 이벤트 유형 문자열만 전달할 수 있습니다.
		이벤트 = 이벤트[ jQuery.expando ] ?
			이벤트 :
			new jQuery.Event( type, typeof event === "object" && event );

		// 비트마스크 트리거: 기본 핸들러의 경우 & 1; jQuery의 경우 & 2(항상 참)
		event.isTrigger = onlyHandlers ? 2:3;
		event.namespace = 네임스페이스.join( "." );
		event.rnamespace = event.namespace ?
			new RegExp( "(^|\\.)" + 네임스페이스.join( "\\.(?:.*\\.|)" ) + "(\\.|$)" ) :
			없는;

		// 재사용되는 경우 이벤트를 정리합니다.
		event.result = 정의되지 않음;
		if ( !event.target ) {
			event.target = 요소;
		}

		// 들어오는 데이터를 복제하고 이벤트 앞에 추가하여 핸들러 인수 목록을 만듭니다.
		데이터 = 데이터 == null ?
			[ 이벤트 ] :
			jQuery.makeArray( data, [ 이벤트 ] );

		// 특별한 이벤트가 선 바깥쪽에 그려지도록 허용합니다.
		특수 = jQuery.event.special[ 유형 ] || {};
		if ( !onlyHandlers && 특수.트리거 && 특수.트리거.apply( elem, 데이터 ) === false ) {
			반품;
		}

		// W3C 이벤트 사양에 따라 이벤트 전파 경로를 미리 결정합니다(#9951).
		// 문서까지 버블링한 다음 창으로 버블링합니다. 전역 소유자를 확인하세요.Document var(#9724)
		if ( !onlyHandlers && !special.noBubble && !isWindow( elem ) ) {

			bubbleType = 특수.delegateType || 유형;
			if ( !rfocusMorph.test( bubbleType + 유형 ) ) {
				현재 = cur.parentNode;
			}
			for ( ; cur; cur = cur.parentNode ) {
				eventPath.push( cur );
				tmp = 현재;
			}

			// 문서에 도달한 경우에만 창을 추가합니다(예: 일반 obj 또는 분리된 DOM이 아님).
			if ( tmp === ( elem.ownerDocument || 문서 ) ) {
				eventPath.push( tmp.defaultView || tmp.parentWindow || 창 );
			}
		}

		// 이벤트 경로에서 핸들러를 실행합니다.
		나는 = 0;
		while ( ( cur = eventPath[ i++ ] ) && !event.isPropagationStopped() ) {
			lastElement = 현재;
			event.type = i > 1 ?
				버블 유형 :
				특수.bindType || 유형;

			// jQuery 핸들러
			핸들 = ( dataPriv.get( cur, "events" ) || Object.create( null ) )[ event.type ] &&
				dataPriv.get( cur, "handle" );
			if (처리) {
				핸들.적용(현재, 데이터);
			}

			// 네이티브 핸들러
			핸들 = 온타입 && cur[ 온타입 ];
			if ( 핸들 && handler.apply && acceptData( cur ) ) {
				event.result = handler.apply( cur, data );
				if (event.result === false ) {
					event.preventDefault();
				}
			}
		}
		event.type = 유형;

		// 누구도 기본 동작을 방해하지 않았다면 지금 수행하세요.
		if ( !onlyHandlers && !event.isDefaultPrevented() ) {

			if ( ( !special._default ||
				특수._default.apply( eventPath.pop(), 데이터 ) === false ) &&
				acceptData( 요소 ) ) {

				// 이벤트와 동일한 이름을 가진 대상에서 기본 DOM 메서드를 호출합니다.
				// 전역 변수가 있는 창에서 기본 작업을 수행하지 마세요. (#6170)
				if ( ontype && isFunction( elem[ type ] ) && !isWindow( elem ) ) {

					// FOO() 메서드를 호출할 때 onFOO 이벤트를 다시 트리거하지 마세요.
					tmp = 요소[온타입];

					만약 (tmp) {
						요소[온타입] = null;
					}

					// 위에서 이미 버블링했기 때문에 동일한 이벤트가 다시 트리거되는 것을 방지합니다.
					jQuery.event.triggered = 유형;

					if ( event.isPropagationStopped() ) {
						lastElement.addEventListener( type, stopPropagationCallback );
					}

					요소[ 유형 ]();

					if ( event.isPropagationStopped() ) {
						lastElement.removeEventListener( type, stopPropagationCallback );
					}

					jQuery.event.triggered = 정의되지 않음;

					만약 (tmp) {
						elem[ ontype ] = tmp;
					}
				}
			}
		}

		이벤트.결과 반환;
	},

	// 다른 이벤트를 시뮬레이션하기 위해 기증자 이벤트에 피기백
	// `focus(in | out)` 이벤트에만 사용됩니다.
	시뮬레이션: 함수( 유형, 요소, 이벤트 ) {
		var e = jQuery.extend(
			새로운 jQuery.Event(),
			이벤트,
			{
				유형: 유형,
				isSimulated: 사실
			}
		);

		jQuery.event.trigger(e, null, elem);
	}

} );

jQuery.fn.extend({

	트리거: 함수( 유형, 데이터 ) {
		return this.each( function() {
			jQuery.event.trigger( 유형, 데이터, this );
		} );
	},
	TriggerHandler: 함수( 유형, 데이터 ) {
		var elem = this[ 0 ];
		if ( 요소 ) {
			return jQuery.event.trigger( type, data, elem, true );
		}
	}
} );


// 지원: 파이어폭스 <=44
// Firefox에는 focus(in | out) 이벤트가 없습니다.
// 관련 티켓 - https://bugzilla.mozilla.org/show_bug.cgi?id=687787
//
// 지원: 크롬 <=48 - 49, 사파리 <=9.0 - 9.1
// focus(in | out) 이벤트는 focus & Blur 이벤트 이후에 발생합니다.
// 이는 사양 위반입니다. - http://www.w3.org/TR/DOM-Level-3-Events/#events-focusevent-event-order
// 관련 티켓 - https://bugs.chromium.org/p/chromium/issues/detail?id=449857
if ( !support.focusin ) {
	jQuery.each( { 초점: "focusin", 흐림: "focusout" }, function( orig, fix ) {

		// 누군가가 포커스 인/포커스 아웃을 원하는 동안 문서에 단일 캡처 핸들러를 연결합니다.
		var 핸들러 = 함수(이벤트) {
			jQuery.event.simulate( fix, event.target, jQuery.event.fix( event ) );
		};

		jQuery.event.special[ 수정 ] = {
			설정: 함수() {

				// 처리: 일반 노드(`this.ownerDocument`를 통해), 창
				// (`this.document`를 통해) & 문서(`this`를 통해).
				var doc = this.ownerDocument || this.문서 || 이것,
					첨부 = dataPriv.access( doc, fix );

				if ( !첨부 ) {
					doc.addEventListener( orig, handler, true );
				}
				dataPriv.access( doc, fix, ( 첨부 || 0 ) + 1 );
			},
			분해: function() {
				var doc = this.ownerDocument || this.문서 || 이것,
					첨부 = dataPriv.access( doc, fix ) - 1;

				if ( !첨부 ) {
					doc.removeEventListener( orig, handler, true );
					dataPriv.remove( doc, fix );

				} 또 다른 {
					dataPriv.access( 문서, 수정, 첨부 );
				}
			}
		};
	} );
}
var 위치 = window.location;

var nonce = { guid: Date.now() };

var rquery = ( /\?/ );



// 크로스 브라우저 XML 구문 분석
jQuery.parseXML = 함수( 데이터 ) {
	var xml, parserErrorElem;
	if ( !data || 데이터 유형 !== "string" ) {
		null을 반환;
	}

	// 지원: IE 9 - 11만 해당
	// IE는 입력이 잘못된 구문 분석에서 발생합니다.
	노력하다 {
		xml = ( new window.DOMParser() ).parseFromString( data, "text/xml" );
	} 잡기 ( 전자 ) {}

	parserErrorElem = xml && xml.getElementsByTagName( "parsererror" )[ 0 ];
	if ( !xml || 파서ErrorElem ) {
		jQuery.error( "잘못된 XML: " + (
			파서ErrorElem?
				jQuery.map( 파서ErrorElem.childNodes, 함수( 엘 ) {
					el.textContent를 반환합니다.
				} ).join( "\n" ) :
				데이터
		) );
	}
	XML을 반환;
};


var
	rbracket = /\[\]$/,
	rCRLF = /\r?\n/g,
	rsubmitterTypes = /^(?:제출|버튼|이미지|재설정|파일)$/i,
	rsubmittable = /^(?:input|select|textarea|keygen)/i;

함수 buildParams( 접두사, obj, 전통, 추가 ) {
	변수 이름;

	if ( Array.isArray( obj ) ) {

		// 배열 항목을 직렬화합니다.
		jQuery.each( obj, function( i, v ) {
			if ( 기존 || rbracket.test( 접두사 ) ) {

				// 각 배열 항목을 스칼라로 처리합니다.
				추가( 접두사, v );

			} 또 다른 {

				// 항목이 스칼라가 아닙니다(배열 또는 객체). 숫자 인덱스를 인코딩합니다.
				buildParams(
					접두사 + "[" + ( typeof v === "object" && v != null ? i : "" ) + "]",
					V,
					전통적인,
					추가하다
				);
			}
		} );

	} else if ( !traditional && toType( obj ) === "객체" ) {

		// 객체 항목을 직렬화합니다.
		for(obj의 이름) {
			buildParams( 접두사 + "[" + 이름 + "]", obj[ 이름 ], Traditional, add );
		}

	} 또 다른 {

		// 스칼라 항목을 직렬화합니다.
		add( 접두사, obj );
	}
}

// 양식 요소의 배열 또는 집합을 직렬화합니다.
// 키/값을 쿼리 문자열로
jQuery.param = function( a, traditional ) {
	var 접두사,
		s = [],
		추가 = 함수( 키, 값OrFunction ) {

			// 값이 함수인 경우 이를 호출하고 반환 값을 사용합니다.
			var value = isFunction( valueOrFunction ) ?
				valueOrFunction() :
				valueOrFunction;

			s[ s.length ] = encodeURIComponent( 키 ) + "=" +
				encodeURIComponent( value == null ? "" : value );
		};

	if ( a == null ) {
		반품 "";
	}

	// 배열이 전달된 경우 양식 요소의 배열이라고 가정합니다.
	if ( Array.isArray( a ) || ( a.jquery && !jQuery.isPlainObject( a ) ) ) {

		// 양식 요소를 직렬화합니다.
		jQuery.each( a, function() {
			add( this.name, this.value );
		} );

	} 또 다른 {

		// 전통적인 경우 "기존" 방식(1.3.2 이전 버전)으로 인코딩합니다.
		// 그랬습니다), 그렇지 않으면 매개변수를 재귀적으로 인코딩합니다.
		for ( 접두사 ) {
			buildParams( 접두사, a[ 접두사 ], 전통, 추가 );
		}
	}

	// 결과 직렬화를 반환합니다.
	return s.join( "&" );
};

jQuery.fn.extend({
	직렬화: function() {
		return jQuery.param( this.serializeArray() );
	},
	serializeArray: 함수() {
		return this.map( function() {

			// 양식 요소를 필터링하거나 추가하기 위해 "요소"에 propHook을 추가할 수 있습니다.
			var elements = jQuery.prop( this, "elements" );
			요소를 반환합니까? jQuery.makeArray( 요소 ) : this;
		} ).filter( 함수() {
			var 유형 = this.type;

			// fieldset[disabled]가 작동하도록 .is( ":disabled" )를 사용하세요.
			return this.name && !jQuery( this ).is( ":disabled" ) &&
				rsubmittable.test( this.nodeName ) && !rsubmitterTypes.test( 유형 ) &&
				( this.checked || !rcheckableType.test( type ) );
		} ).map( 함수( _i, elem ) {
			var val = jQuery( this ).val();

			if (val == null ) {
				null을 반환;
			}

			if ( Array.isArray( val ) ) {
				return jQuery.map( val, function( val ) {
					return { 이름: elem.name, 값: val.replace( rCRLF, "\r\n" ) };
				} );
			}

			return { 이름: elem.name, 값: val.replace( rCRLF, "\r\n" ) };
		} ).얻다();
	}
} );


var
	r20 = /%20/g,
	rhash = /#.*$/,
	rantiCache = /([?&])_=[^&]*/,
	rheaders = /^(.*?):[ \t]*([^\r\n]*)$/mg,

	// #7653, #8125, #8152: 로컬 프로토콜 감지
	rlocalProtocol = /^(?:about|app|app-storage|.+-extension|file|res|widget):$/,
	rnoContent = /^(?:GET|HEAD)$/,
	rprotocol = /^\/\//,

	/* 사전 필터
	 * 1) 사용자 정의 dataType을 도입하는 데 유용합니다(예제는 ajax/jsonp.js 참조).
	 * 2) 이를 다음과 같이 부릅니다.
	 * - 교통편을 요청하기 전에
	 * - 매개변수 직렬화 이후(s.processData가 true인 경우 s.data는 문자열임)
	 * 3) 키는 데이터 유형입니다.
	 * 4) 포괄 기호 "*"를 사용할 수 있습니다.
	 * 5) 실행은 전송 데이터 유형으로 시작되고 필요한 경우 "*"까지 계속됩니다.
	 */
	사전 필터 = {},

	/* 바인딩을 전송합니다.
	 * 1) 키는 데이터 유형입니다.
	 * 2) 포괄 기호 "*"를 사용할 수 있습니다.
	 * 3) 선택은 전송 데이터 유형으로 시작하고 필요한 경우 "*"로 이동합니다.
	 */
	전송 = {},

	// 주석-프롤로그 문자 시퀀스를 피합니다(#10098). 보푸라기를 달래고 압축을 피해야 합니다.
	allTypes = "*/".concat( "*" ),

	// 문서 원본을 구문 분석하기 위한 앵커 태그
	OriginAnchor = document.createElement( "a" );

OriginAnchor.href = 위치.href;

// jQuery.ajaxPrefilter 및 jQuery.ajaxTransport에 대한 기본 "생성자"
함수 addToPrefiltersOrTransports(구조) {

	// dataTypeExpression은 선택사항이며 기본값은 "*"입니다.
	반환 함수( dataTypeExpression, func ) {

		if ( typeof dataTypeExpression !== "string" ) {
			func = dataTypeExpression;
			dataTypeExpression = "*";
		}

		var 데이터 유형,
			나는 = 0,
			dataTypes = dataTypeExpression.toLowerCase().match( rnothtmlwhite ) || [];

		if ( isFunction( func ) ) {

			// dataTypeExpression의 각 데이터 유형에 대해
			while ( ( dataType = dataTypes[ i++ ] ) ) {

				// 요청 시 앞에 추가
				if ( 데이터 유형[ 0 ] === "+" ) {
					dataType = dataType.slice( 1 ) || "*";
					( 구조[ 데이터 유형 ] = 구조[ 데이터 유형 ] || [] ).unshift( func );

				// 그렇지 않으면 추가
				} 또 다른 {
					( 구조[ 데이터 유형 ] = 구조[ 데이터 유형 ] || [] ).push( func );
				}
			}
		}
	};
}

// 사전 필터 및 전송에 대한 기본 검사 기능
함수spectPrefiltersOrTransports(구조,옵션,originalOptions,jqXHR){

	검사된 var = {},
		lookingTransport = (구조 === 전송);

	함수 검사( dataType ) {
		var가 선택되었습니다.
		검사됨[ dataType ] = true;
		jQuery.each( 구조[ dataType ] || [], function( _, prefilterOrFactory ) {
			var dataTypeOrTransport = prefilterOrFactory( options, originalOptions, jqXHR );
			if ( dataTypeOrTransport 유형 === "문자열" &&
				!seekingTransport && !inspected[ dataTypeOrTransport ] ) {

				options.dataTypes.unshift( dataTypeOrTransport );
				검사(dataTypeOrTransport);
				거짓을 반환;
			} else if (Transport 탐색) {
				return !(선택됨 = dataTypeOrTransport);
			}
		} );
		선택됨;
	}

	반환 검사( options.dataTypes[ 0 ] ) || !검사됨[ "*" ] && 검사( "*" );
}

// Ajax 옵션을 위한 특수 확장
// "플랫" 옵션을 사용합니다(깊이 확장되지 않음).
// 수정 #9887
함수 ajaxExtend( 대상, src ) {
	var 키, 깊은,
		flatOptions = jQuery.ajaxSettings.FlatOptions || {};

	for ( src의 키 ) {
		if ( src[ 키 ] !== 정의되지 않음 ) {
			( flatOptions[ 키 ] ? 대상 : ( deep || ( deep = {} ) ) )[ 키 ] = src[ 키 ];
		}
	}
	if (깊은) {
		jQuery.extend( true, target, deep );
	}

	반환 대상;
}

/* Ajax 요청에 대한 응답을 처리합니다.
 * - 올바른 dataType을 찾습니다(content-type과 예상 dataType 사이를 중재).
 * - 해당 응답을 반환합니다.
 */
함수 ajaxHandleResponses(s, jqXHR, 응답) {

	var ct, 유형, finalDataType, firstDataType,
		내용 = s.내용,
		dataTypes = s.dataTypes;

	// 자동 dataType을 제거하고 프로세스에서 콘텐츠 유형을 가져옵니다.
	while ( dataTypes[ 0 ] === "*" ) {
		dataTypes.shift();
		if (ct === 정의되지 않음) {
			ct = s.mimeType || jqXHR.getResponseHeader( "콘텐츠 유형" );
		}
	}

	// 알려진 콘텐츠 유형을 다루고 있는지 확인합니다.
	만약 (ct) {
		for ( 내용 입력 ) {
			if ( 내용[ 유형 ] && 내용[ 유형 ].test( ct ) ) {
				dataTypes.unshift( 유형 );
				부서지다;
			}
		}
	}

	// 예상되는 dataType에 대한 응답이 있는지 확인합니다.
	if ( 응답의 dataTypes[ 0 ] ) {
		finalDataType = 데이터 유형[ 0 ];
	} 또 다른 {

		// 변환 가능한 데이터 유형을 사용해 보세요.
		for ( 응답 입력 ) {
			if ( !dataTypes[ 0 ] || s.converters[ type + " " + dataTypes[ 0 ] ] ) {
				finalDataType = 유형;
				부서지다;
			}
			if ( !firstDataType ) {
				firstDataType = 유형;
			}
		}

		// 아니면 그냥 첫 번째 것을 사용하세요
		finalDataType = finalDataType || 첫 번째 데이터 유형;
	}

	// dataType을 찾은 경우
	// 필요한 경우 목록에 dataType을 추가합니다.
	// 그리고 해당 응답을 반환합니다.
	if (최종 데이터 유형) {
		if ( finalDataType !== dataTypes[ 0 ] ) {
			dataTypes.unshift( finalDataType );
		}
		응답 반환[ finalDataType ];
	}
}

/* 요청과 원래 응답에 따른 연쇄 변환
 * 또한 jqXHR 인스턴스에 responseXXX 필드를 설정합니다.
 */
함수 ajaxConvert(s, response, jqXHR, isSuccess) {
	var 전환2, 현재, 전환, tmp, 이전,
		변환기 = {},

		// 변환을 위해 수정해야 하는 경우 dataType의 복사본으로 작업합니다.
		dataTypes = s.dataTypes.slice();

	// 소문자 키를 사용하여 변환기 맵을 생성합니다.
	if ( 데이터 유형[ 1 ] ) {
		for ( s.converters의 전환 ) {
			변환기[ conv.toLowerCase() ] = s.converters[ 변환 ];
		}
	}

	현재 = dataTypes.shift();

	// 각 순차적 dataType으로 변환
	동안(현재) {

		if ( s.responseFields[ 현재 ] ) {
			jqXHR[ s.responseFields[ 현재 ] ] = 응답;
		}

		// 제공된 경우 dataFilter를 적용합니다.
		if ( !prev && isSuccess && s.dataFilter ) {
			response = s.dataFilter( response, s.dataType );
		}

		이전 = 현재;
		현재 = dataTypes.shift();

		if (현재) {

			// 현재 데이터 유형이 자동이 아닌 경우에만 수행할 작업이 있습니다.
			if ( 현재 === "*" ) {

				현재 = 이전;

			// 이전 데이터 유형이 자동이 아니고 현재 데이터 유형과 다른 경우 응답을 변환합니다.
			} else if ( 이전 !== "*" && 이전 !== 현재 ) {

				// 직접 변환기를 찾습니다.
				전환 = 변환기[ 이전 + " " + 현재 ] || 변환기[ "* " + 현재 ];

				// 아무것도 찾지 못하면 쌍을 찾습니다.
				만약 ( !conv ) {
					for ( 변환기의 전환2 ) {

						//conv2가 전류를 출력하는 경우
						tmp = conv2.split( " " );
						if ( tmp[ 1 ] === 현재 ) {

							// prev를 허용된 입력으로 변환할 수 있는 경우
							전환 = 변환기[ prev + " " + tmp[ 0 ] ] ||
								변환기[ "* " + tmp[ 0 ] ];
							만약 (전환) {

								// 등가 변환기를 압축합니다.
								if(전환 === true) {
									전환 = 변환기[ 전환2 ];

								// 그렇지 않으면 중간 dataType을 삽입합니다.
								} else if ( 변환기[ 전환2 ] !== true ) {
									현재 = tmp[ 0 ];
									dataTypes.unshift( tmp[ 1 ] );
								}
								부서지다;
							}
						}
					}
				}

				// 변환기 적용(동등하지 않은 경우)
				if ( 전환 !== true ) {

					// 오류가 버블링되도록 허용되지 않는 한 오류를 잡아서 반환합니다.
					if (conv && s.throws) {
						응답 = 전환(응답);
					} 또 다른 {
						노력하다 {
							응답 = 전환(응답);
						} 잡기 ( 전자 ) {
							반품 {
								상태: "파서 오류",
								오류: 전환? e: "" + prev + "에서 " + 현재로 변환되지 않습니다.
							};
						}
					}
				}
			}
		}
	}

	return { 상태: "성공", 데이터: 응답 };
}

jQuery.확장({

	// 활성 쿼리 수를 보유하는 카운터
	활성: 0,

	// 다음 요청을 위해 마지막으로 수정된 헤더 캐시
	마지막 수정: {},
	에태그: {},

	아약스설정: {
		URL: 위치.href,
		유형: "GET",
		isLocal: rlocalProtocol.test( location.protocol ),
		글로벌: 사실,
		프로세스 데이터: 사실,
		비동기: 사실,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",

		/*
		시간 초과: 0,
		데이터: null,
		데이터 유형: null,
		사용자 이름: null,
		비밀번호: null,
		캐시: null,
		던지기: 거짓,
		전통적: 거짓,
		헤더: {},
		*/

		수락: {
			"*": 모든 유형,
			text: "텍스트/일반",
			HTML: "텍스트/html",
			xml: "응용 프로그램/xml, 텍스트/xml",
			json: "응용 프로그램/json, 텍스트/자바스크립트"
		},

		내용물: {
			xml: /\bxml\b/,
			HTML: /\bhtml/,
			json: /\bjson\b/
		},

		응답 필드: {
			xml: "responseXML",
			텍스트: "응답텍스트",
			json: "응답JSON"
		},

		// 데이터 변환기
		// 키는 단일 공백으로 소스(또는 포괄 "*") 및 대상 유형을 구분합니다.
		변환기: {

			// 무엇이든 텍스트로 변환
			"* 텍스트": 문자열,

			// 텍스트를 html로(true = 변환 없음)
			"텍스트 HTML": 사실,

			// JSON 표현식으로 텍스트를 평가합니다.
			"텍스트 JSON": JSON.parse,

			// 텍스트를 xml로 구문 분석합니다.
			"텍스트 xml": jQuery.parseXML
		},

		// 깊게 확장하면 안 되는 옵션의 경우:
		// 여기에 사용자 정의 옵션을 추가할 수 있는 경우
		// 그리고 있어서는 안 되는 것을 생성할 때
		// 깊은 확장(ajaxExtend 참조)
		플랫옵션: {
			URL: 사실,
			맥락: 사실
		}
	},

	// 완전한 기능을 갖춘 설정 개체를 대상으로 생성합니다.
	// ajaxSettings 및 설정 필드를 모두 사용합니다.
	// target이 생략되면 ajaxSettings에 씁니다.
	ajaxSetup: 함수(대상, 설정) {
		반환 설정 ?

			// 설정 개체 만들기
			ajaxExtend( ajaxExtend( target, jQuery.ajaxSettings ), 설정 ) :

			// ajaxSettings 확장
			ajaxExtend(jQuery.ajaxSettings, target);
	},

	ajaxPrefilter: addToPrefiltersOrTransports( prefilters ),
	ajaxTransport: addToPrefiltersOrTransports( 전송 ),

	// 주요 메소드
	아약스: 함수( url, 옵션 ) {

		// url이 객체인 경우 1.5 이전 서명을 시뮬레이션합니다.
		if ( url 유형 === "객체" ) {
			옵션 = URL;
			URL = 정의되지 않음;
		}

		// 옵션을 객체로 강제 적용
		옵션 = 옵션 || {};

		var 운송,

			// 안티 캐시 매개변수가 없는 URL
			캐시URL,

			// 응답 헤더
			응답헤더문자열,
			응답헤더,

			// 타임아웃 핸들
			시간 초과타이머,

			// URL 정리 var
			URL앵커,

			// 요청 상태(전송 시 false가 되고 완료 시 true가 됨)
			완전한,

			// 전역 이벤트가 전달되는지 확인하기 위해
			화재글로벌,

			// 루프 변수
			나,

			// URL의 캐시되지 않은 부분
			캐시되지 않은,

			// 최종 옵션 객체 생성
			s = jQuery.ajaxSetup({}, 옵션),

			// 콜백 컨텍스트
			callbackContext = s.context || 에스,

			// 전역 이벤트의 컨텍스트는 DOM 노드 또는 jQuery 컬렉션인 경우 callbackContext입니다.
			globalEventContext = s.context &&
				( callbackContext.nodeType || callbackContext.jquery ) ?
				jQuery(콜백컨텍스트):
				jQuery.이벤트,

			// 연기됨
			지연된 = jQuery.Deferred(),
			CompleteDeferred = jQuery.Callbacks( "한 번 메모리" ),

			// 상태에 따른 콜백
			statusCode = s.statusCode || {},

			// 헤더(한 번에 전송됨)
			요청헤더 = {},
			requestHeadersNames = {},

			// 기본 중단 메시지
			strAbort = "취소됨",

			// 가짜 xhr
			jqXHR = {
				준비상태: 0,

				// 필요한 경우 헤더 해시테이블을 생성합니다.
				getResponseHeader: 함수( 키 ) {
					var 일치;
					if (완료) {
						if (!responseHeaders) {
							응답헤더 = {};
							while ( ( match = rheaders.exec( responseHeadersString ) ) ) {
								responseHeaders[ match[ 1 ].toLowerCase() + " " ] =
									( responseHeaders[ match[ 1 ].toLowerCase() + " " ] || [] )
										.concat( 일치[ 2 ] );
							}
						}
						match = responseHeaders[ key.toLowerCase() + " " ];
					}
					반환 일치 == null ? null : match.join( ", " );
				},

				// 원시 문자열
				getAllResponseHeaders: 함수() {
					반납완료? responseHeadersString : null;
				},

				// 헤더를 캐시합니다.
				setRequestHeader: 함수( 이름, 값 ) {
					if (완료 == null ) {
						이름 = requestHeadersNames[ name.toLowerCase() ] =
							requestHeadersNames[ name.toLowerCase() ] || 이름;
						요청헤더[ 이름 ] = 값;
					}
					이거 돌려줘;
				},

				// 응답 콘텐츠 유형 헤더를 재정의합니다.
				overrideMimeType: 함수( 유형 ) {
					if (완료 == null ) {
						s.mimeType = 유형;
					}
					이거 돌려줘;
				},

				// 상태에 따른 콜백
				statusCode: 함수( 지도 ) {
					var 코드;
					만약 (지도) {
						if (완료) {

							// 적절한 콜백을 실행합니다.
							jqXHR.always( 지도[ jqXHR.status ] );
						} 또 다른 {

							// 이전 콜백을 유지하는 방식으로 새 콜백을 지연 추가합니다.
							for ( 지도의 코드 ) {
								statusCode[ 코드 ] = [ statusCode[ 코드 ], 지도[ 코드 ] ];
							}
						}
					}
					이거 돌려줘;
				},

				// 요청 취소
				중단: 함수( statusText ) {
					var finalText = statusText || strAbort;
					만약 (운송) {
						Transport.abort( finalText );
					}
					완료(0, finalText);
					이거 돌려줘;
				}
			};

		// 지연된 항목 첨부
		deferred.promise( jqXHR );

		// 제공되지 않은 경우 프로토콜을 추가합니다(사전 필터에서 예상할 수 있음).
		// 설정 개체에서 잘못된 URL을 처리합니다. (#10093: 이전 서명과의 일관성)
		// 가능한 경우 url 매개변수도 사용합니다.
		s.url = ( ( ( url || s.url || location.href ) + "" )
			.replace( rprotocol, location.protocol + "//" );

		// 티켓 #12004에 따라 입력하는 별칭 메서드 옵션
		s.type = options.method || 옵션.유형 || s.방법 || s.유형;

		// 데이터 유형 목록 추출
		s.dataTypes = ( s.dataType || "*" ).toLowerCase().match( rnothtmlwhite ) || [ "" ];

		// 원본이 현재 원본과 일치하지 않는 경우 교차 도메인 요청이 순서대로 이루어집니다.
		if ( s.crossDomain == null ) {
			urlAnchor = document.createElement( "a" );

			// 지원: IE <=8 - 11, 엣지 12 - 15
			// URL 형식이 잘못된 경우 IE는 href 속성에 액세스할 때 예외를 발생시킵니다.
			// 예: http://example.com:80x/
			노력하다 {
				urlAnchor.href = s.url;

				// 지원: IE <=8 - 11만
				// s.url이 상대적인 경우 앵커의 호스트 속성이 올바르게 설정되지 않습니다.
				urlAnchor.href = urlAnchor.href;
				s.crossDomain = OriginAnchor.protocol + "//" + OriginAnchor.host !==
					urlAnchor.protocol + "//" + urlAnchor.host;
			} 잡기 ( 전자 ) {

				// URL을 파싱하는 중 오류가 발생하면 crossDomain이라고 가정하고,
				// 유효하지 않은 경우 전송에 의해 거부될 수 있습니다.
				s.crossDomain = true;
			}
		}

		// 아직 문자열이 아닌 경우 데이터를 변환합니다.
		if ( s.data && s.processData && typeof s.data !== "string" ) {
			s.data = jQuery.param( s.data, s.traditional );
		}

		// 사전 필터 적용
		InspectionPrefiltersOrTransports( prefilters, s, options, jqXHR );

		// 사전 필터 내에서 요청이 중단된 경우 거기서 중지합니다.
		if (완료) {
			jqXHR을 반환합니다.
		}

		// 요청하면 지금부터 전역 이벤트를 실행할 수 있습니다.
		// AMD 사용 시나리오에서 jQuery.event가 정의되지 않은 경우 이벤트를 실행하지 마세요(#15118)
		fireGlobals = jQuery.event && s.global;

		// 새로운 요청 세트를 감시합니다.
		if ( fireGlobals && jQuery.active++ === 0 ) {
			jQuery.event.trigger( "ajaxStart" );
		}

		// 유형을 대문자로 표시
		s.type = s.type.toUpperCase();

		// 요청에 내용이 있는지 확인
		s.hasContent = !rnoContent.test( s.type );

		// If-Modified-Since를 사용할 경우를 대비하여 URL을 저장합니다.
		// 및/또는 나중에 If-None-Match 헤더를 사용합니다.
		// URL 조작을 단순화하기 위해 해시를 제거합니다.
		캐시URL = s.url.replace( rhash, "" );

		// 내용이 없는 요청을 처리하는 추가 옵션
		if ( !s.hasContent ) {

			// 다시 넣을 수 있도록 해시를 기억해 두세요.
			캐시되지 않은 = s.url.slice(cacheURL.length);

			// 데이터가 사용 가능하고 처리되어야 하는 경우 데이터를 URL에 추가합니다.
			if ( s.data && ( s.processData || typeof s.data === "string" ) ) {
				캐시URL += ( rquery.test( 캐시URL ) ? "&" : "?" ) + s.data;

				// #9682: 최종 재시도에 사용되지 않도록 데이터를 제거합니다.
				s.data 삭제;
			}

			// 필요한 경우 안티 캐시 매개변수를 추가하거나 업데이트합니다.
			if ( s.cache === false ) {
				캐시URL = 캐시URL.replace( rantiCache, "$1" );
				캐시되지 않음 = ( rquery.test( 캐시 URL ) ? "&" : "?" ) + "_=" + ( nonce.guid++ ) +
					캐시되지 않은;
			}

			// 요청할 URL에 해시와 안티캐시를 넣습니다. (gh-1732)
			s.url = 캐시URL + 캐시되지 않음;

		// 본문 내용(gh-2658)에서 인코딩된 경우 '%20'을 '+'로 변경합니다.
		} else if ( s.data && s.processData &&
			( s.contentType || "" ).indexOf( "application/x-www-form-urlencoded" ) === 0 ) {
			s.data = s.data.replace( r20, "+" );
		}

		// ifModified 모드인 경우 If-Modified-Since 및/또는 If-None-Match 헤더를 설정합니다.
		if ( s.ifModified ) {
			if ( jQuery.lastModified[ 캐시URL ] ) {
				jqXHR.setRequestHeader( "If-Modified-Since", jQuery.lastModified[ 캐시URL ] );
			}
			if ( jQuery.etag[ 캐시URL ] ) {
				jqXHR.setRequestHeader( "If-None-Match", jQuery.etag[ 캐시URL ] );
			}
		}

		// 데이터가 전송되는 경우 올바른 헤더를 설정합니다.
		if ( s.data && s.hasContent && s.contentType !== false || options.contentType ) {
			jqXHR.setRequestHeader( "Content-Type", s.contentType );
		}

		// dataType에 따라 서버의 Accepts 헤더를 설정합니다.
		jqXHR.setRequestHeader(
			"수용하다",
			s.dataTypes[ 0 ] && s.accepts[ s.dataTypes[ 0 ] ] ?
				s.accepts[ s.dataTypes[ 0 ] ] +
					( s.dataTypes[ 0 ] !== "*" ? ", " + allTypes + "; q=0.01" : "" ) :
				s.accepts[ "*" ]
		);

		// 헤더 옵션 확인
		for ( i in s.headers ) {
			jqXHR.setRequestHeader( i, s.headers[ i ] );
		}

		// 사용자 정의 헤더/Mimetype 및 조기 중단을 허용합니다.
		if ( s.beforeSend &&
			( s.beforeSend.call( callbackContext, jqXHR, s ) === false || 완료 ) ) {

			// 아직 완료되지 않은 경우 중단하고 반환합니다.
			jqXHR.abort()를 반환합니다.
		}

		// 중단은 더 이상 취소가 아닙니다.
		strAbort = "중단";

		// 연기된 항목에 콜백을 설치합니다.
		완료Deferred.add( s.complete );
		jqXHR.done(s.success);
		jqXHR.fail(s.error);

		// 교통수단 얻기
		Transport = InspectionPrefiltersOrTransports( Transports, s, options, jqXHR );

		// 전송이 없으면 자동 중단됩니다.
		if ( !transport ) {
			done( -1, "전송 없음" );
		} 또 다른 {
			jqXHR.readyState = 1;

			// 전역 이벤트 보내기
			if (fireGlobals) {
				globalEventContext.trigger( "ajaxSend", [ jqXHR, s ] );
			}

			// ajaxSend 내에서 요청이 중단된 경우 거기서 중지합니다.
			if (완료) {
				jqXHR을 반환합니다.
			}

			// 시간 초과
			if ( s.async && s.timeout > 0 ) {
				timeoutTimer = window.setTimeout( function() {
					jqXHR.abort( "timeout" );
				}, s.timeout );
			}

			노력하다 {
				완료 = 거짓;
				Transport.send( requestHeaders, 완료 );
			} 잡기 ( 전자 ) {

				// 완료 후 예외 다시 발생
				if (완료) {
					전자를 던져;
				}

				// 다른 결과를 결과로 전파
				완료( -1, e );
			}
		}

		// 모든 작업이 완료되었을 때를 위한 콜백
		함수 완료(상태, NativeStatusText, 응답, 헤더) {
			var isSuccess, 성공, 오류, 응답, 수정됨,
				statusText = 기본StatusText;

			// 반복 호출 무시
			if (완료) {
				반품;
			}

			완료 = 사실;

			// 시간 초과가 있으면 삭제합니다.
			if (타임아웃타이머) {
				window.clearTimeout(timeoutTimer);
			}

			// 초기 가비지 수집을 위한 역참조 전송
			// (jqXHR 객체가 얼마나 오랫동안 사용되든 상관없음)
			운송 = 정의되지 않음;

			// 캐시 응답 헤더
			responseHeadersString = 헤더 || "";

			// 준비 상태 설정
			jqXHR.readyState = 상태 > 0 ? 4:0;

			//성공 여부 판단
			isSuccess = 상태 >= 200 && 상태 < 300 || 상태 === 304;

			// 응답 데이터 가져오기
			if (응답) {
				response = ajaxHandleResponses(s, jqXHR, response);
			}

			// 스크립트가 누락된 경우 noop 변환기를 사용하지만 jsonp인 경우에는 사용하지 않음
			if ( !isSuccess &&
				jQuery.inArray( "script", s.dataTypes ) > -1 &&
				jQuery.inArray( "json", s.dataTypes ) < 0 ) {
				s.converters[ "text script" ] = function() {};
			}

			// 무슨 일이 있어도 변환합니다(이렇게 하면 responseXXX 필드가 항상 설정됩니다).
			response = ajaxConvert(s, response, jqXHR, isSuccess);

			// 성공하면 유형 체이닝을 처리합니다.
			if ( isSuccess ) {

				// ifModified 모드인 경우 If-Modified-Since 및/또는 If-None-Match 헤더를 설정합니다.
				if ( s.ifModified ) {
					수정됨 = jqXHR.getResponseHeader( "마지막 수정" );
					if (수정됨) {
						jQuery.lastModified[ 캐시URL ] = 수정됨;
					}
					수정됨 = jqXHR.getResponseHeader( "etag" );
					if (수정됨) {
						jQuery.etag[ 캐시URL ] = 수정됨;
					}
				}

				//내용이 없을 경우
				if ( status === 204 || s.type === "HEAD" ) {
					statusText = "콘텐츠 없음";

				// 수정하지 않은 경우
				} else if ( 상태 === 304 ) {
					statusText = "수정되지 않음";

				//데이터가 있으면 변환하자
				} 또 다른 {
					statusText = 응답.상태;
					성공 = response.data;
					오류 = 응답.오류;
					isSuccess = !오류;
				}
			} 또 다른 {

				// statusText에서 오류를 추출하고 중단되지 않은 항목을 정규화합니다.
				오류 = 상태텍스트;
				if ( 상태 || !statusText ) {
					statusText = "오류";
					if (상태 < 0) {
						상태 = 0;
					}
				}
			}

			// 가짜 xhr 객체에 대한 데이터 설정
			jqXHR.status = 상태;
			jqXHR.statusText = ( NativeStatusText || statusText ) + "";

			// 성공/오류
			if ( isSuccess ) {
				deferred.resolveWith( callbackContext, [ 성공, statusText, jqXHR ] );
			} 또 다른 {
				deferred.rejectWith( callbackContext, [ jqXHR, statusText, error ] );
			}

			// 상태에 따른 콜백
			jqXHR.statusCode( statusCode );
			상태 코드 = 정의되지 않음;

			if (fireGlobals) {
				globalEventContext.trigger( isSuccess ? "ajaxSuccess" : "ajaxError",
					[ jqXHR, s, isSuccess ? 성공 : 오류 ] );
			}

			// 완벽한
			CompleteDeferred.fireWith( callbackContext, [ jqXHR, statusText ] );

			if (fireGlobals) {
				globalEventContext.trigger( "ajaxComplete", [ jqXHR, s ] );

				// 전역 AJAX 카운터를 처리합니다.
				if ( !( --jQuery.active ) ) {
					jQuery.event.trigger( "ajaxStop" );
				}
			}
		}

		jqXHR을 반환합니다.
	},

	getJSON: 함수(url, 데이터, 콜백) {
		return jQuery.get( url, data, callback, "json" );
	},

	getScript: 함수(url, 콜백) {
		return jQuery.get( url, 정의되지 않음, 콜백, "script" );
	}
} );

jQuery.each( [ "get", "post" ], function( _i, method ) {
	jQuery[ 메서드 ] = 함수( url, 데이터, 콜백, 유형 ) {

		// 데이터 인수가 생략된 경우 인수 이동
		if ( isFunction( 데이터 ) ) {
			유형 = 유형 || 콜백;
			콜백 = 데이터;
			데이터 = 정의되지 않음;
		}

		// URL은 옵션 객체일 수 있습니다(그러면 .url이 있어야 함).
		return jQuery.ajax( jQuery.extend( {
			URL: URL,
			유형: 방법,
			데이터 유형: 유형,
			데이터: 데이터,
			성공: 콜백
		}, jQuery.isPlainObject( url ) && url ) );
	};
} );

jQuery.ajaxPrefilter( 함수( s ) {
	var i;
	for ( i in s.headers ) {
		if ( i.toLowerCase() === "콘텐츠 유형" ) {
			s.contentType = s.headers[ i ] || "";
		}
	}
} );


jQuery._evalUrl = function( url, options, doc ) {
	jQuery.ajax({
		URL: URL,

		// 사용자가 ajaxSetup을 통해 이를 재정의할 수 있으므로 이를 명시적으로 만듭니다(#11264).
		유형: "GET",
		데이터 유형: "스크립트",
		캐시: 사실,
		비동기: 거짓,
		글로벌: 거짓,

		// 성공한 경우에만 응답을 평가합니다. (gh-4126)
		// 실패 응답에 대해서는 dataFilter가 호출되지 않으므로 대신 사용합니다.
		// 기본 변환기는 복잡하지만 작동합니다.
		변환기: {
			"텍스트 스크립트": fu nction() {}
		},
		dataFilter: 함수(응답) {
			jQuery.globalEval(응답, 옵션, 문서);
		}
	} );
};


jQuery.fn.extend({
	WrapAll: 함수( html ) {
		var 랩;

		if ( this[ 0 ] ) {
			if ( isFunction( html ) ) {
				html = html.call( this[ 0 ] );
			}

			// 타겟을 둘러쌀 요소
			Wrap = jQuery( html, this[ 0 ].ownerDocument ).eq( 0 ).clone( true );

			if ( this[ 0 ].parentNode ) {
				Wrap.insertBefore( this[ 0 ] );
			}

			Wrap.map(함수() {
				var elem = 이것;

				동안( elem.firstElementChild ) {
					elem = elem.firstElementChild;
				}

				요소를 반환;
			} ).추가( this );
		}

		이거 돌려줘;
	},

	WrapInner: 함수( html ) {
		if ( isFunction( html ) ) {
			return this.each( 함수( i ) {
				jQuery( this ).wrapInner( html.call( this, i ) );
			} );
		}

		return this.each( function() {
			var self = jQuery( this ),
				내용 = self.contents();

			if (내용.길이) {
				내용.wrapAll(html);

			} 또 다른 {
				self.append(html);
			}
		} );
	},

	포장: 함수(html) {
		var htmlIsFunction = isFunction( html );

		return this.each( 함수( i ) {
			jQuery( this ).wrapAll( htmlIsFunction ? html.call( this, i ) : html );
		} );
	},

	unwrap: 함수( 선택기 ) {
		this.parent( 선택기 ).not( "body" ).each( function() {
			jQuery( this ).replaceWith( this.childNodes );
		} );
		이거 돌려줘;
	}
} );


jQuery.expr.pseudos.hidden = 함수( elem ) {
	return !jQuery.expr.pseudos.visible( elem );
};
jQuery.expr.pseudos.visible = 함수( elem ) {
	return !!( elem.offsetWidth || elem.offsetHeight || elem.getClientRects().length );
};




jQuery.ajaxSettings.xhr = 함수() {
	노력하다 {
		새 window.XMLHttpRequest()를 반환합니다.
	} 잡기 ( 전자 ) {}
};

var xhrSuccessStatus = {

		// 파일 프로토콜은 항상 상태 코드 0을 생성하고 200으로 가정합니다.
		0:200,

		// 지원: IE <=9만 해당
		// #1450: 때때로 IE는 204여야 하는데 1223을 반환합니다.
		1223:204
	},
	xhrSupported = jQuery.ajaxSettings.xhr();

support.cors = !!xhrSupported && ( xhrSupported 의 "withCredentials");
support.ajax = xhrSupported = !!xhrSupported;

jQuery.ajaxTransport(함수(옵션)) {
	var 콜백, errorCallback;

	// XMLHttpRequest를 통해 지원되는 경우에만 교차 도메인이 허용됩니다.
	if ( support.cors || xhrSupported && !options.crossDomain ) {
		반품 {
			보내기: 함수(헤더, 완료) {
				내가,
					xhr = 옵션.xhr();

				xhr.open(
					옵션.유형,
					옵션.url,
					옵션.비동기,
					옵션.사용자 이름,
					옵션.비밀번호
				);

				// 제공된 경우 사용자 정의 필드를 적용합니다.
				if (옵션.xhrFields) {
					for ( i in options.xhrFields ) {
						xhr[ i ] = 옵션.xhrFields[ i ];
					}
				}

				// 필요한 경우 MIME 유형을 재정의합니다.
				if ( options.mimeType && xhr.overrideMimeType ) {
					xhr.overrideMimeType( options.mimeType );
				}

				// X-Requested-With 헤더
				// 도메인 간 요청의 경우 프리플라이트 조건은 다음과 같습니다.
				// 직소 퍼즐과 유사하게, 우리는 그것을 확실하게 설정하지 않습니다.
				// (항상 요청별로 또는 ajaxSetup을 사용하여 설정할 수 있음)
				// 동일한 도메인 요청의 경우 이미 제공된 경우 헤더를 변경하지 않습니다.
				if ( !options.crossDomain && !headers[ "X-Requested-With" ] ) {
					헤더[ "X-Requested-With" ] = "XMLHttpRequest";
				}

				// 헤더 설정
				for ( 헤더의 i ) {
					xhr.setRequestHeader( i, headers[ i ] );
				}

				// 콜백
				콜백 = 함수( 유형 ) {
					반환 함수() {
						if(콜백) {
							콜백 = errorCallback = xhr.onload =
								xhr.onerror = xhr.onabort = xhr.ontimeout =
									xhr.onreadystatechange = null;

							if ( type === "중단" ) {
								xhr.abort();
							} else if ( type === "오류" ) {

								// 지원: IE <=9만 해당
								// 수동 네이티브 중단 시 IE9에서는 다음이 발생합니다.
								//readyState가 아닌 속성 액세스에 대한 오류
								if ( xhr.status 유형 !== "번호" ) {
									완료( 0, "오류" );
								} 또 다른 {
									완벽한(

										// 파일: 프로토콜은 항상 상태 0을 생성합니다. #8605, #14207 참조
										xhr.상태,
										xhr.status텍스트
									);
								}
							} 또 다른 {
								완벽한(
									xhrSuccessStatus[ xhr.status ] || xhr.상태,
									xhr.status텍스트,

									// 지원: IE <=9만 해당
									// IE9에는 XHR2가 없지만 바이너리를 발생시킵니다. (trac-11426)
									// 텍스트가 아닌 XHR2의 경우 호출자가 처리하도록 합니다(gh-2498).
									( xhr.responseType || "텍스트" ) !== "텍스트" ||
									xhr.responseText 유형 !== "문자열" ?
										{ 바이너리: xhr.response } :
										{ 텍스트: xhr.responseText },
									xhr.getAllResponseHeaders()
								);
							}
						}
					};
				};

				// 이벤트 듣기
				xhr.onload = 콜백();
				errorCallback = xhr.onerror = xhr.ontimeout = 콜백( "error" );

				// 지원: IE 9만 해당
				// onabort를 대체하려면 onreadystatechange를 사용하세요.
				// 포착되지 않은 중단을 처리하기 위해
				if ( xhr.onabort !== 정의되지 않음 ) {
					xhr.onabort = errorCallback;
				} 또 다른 {
					xhr.onreadystatechange = 함수() {

						// 시간이 초과되기 전에 ReadyState가 변경되는지 확인하세요.
						if ( xhr.readyState === 4 ) {

							// onerror가 먼저 호출되도록 허용합니다.
							// 하지만 네이티브 중단은 처리되지 않습니다.
							// 또한 errorCallback을 변수에 저장합니다.
							// xhr.onerror에 접근할 수 없기 때문에
							window.setTimeout(함수() {
								if(콜백) {
									errorCallback();
								}
							} );
						}
					};
				}

				// 중단 콜백 생성
				콜백 = 콜백( "중단" );

				노력하다 {

					// 요청을 보냅니다(예외가 발생할 수 있음).
					xhr.send( options.hasContent && options.data || null );
				} 잡기 ( 전자 ) {

					// #14683: 아직 오류로 통보되지 않은 경우에만 다시 발생합니다.
					if(콜백) {
						전자를 던져;
					}
				}
			},

			중단: 함수() {
				if(콜백) {
					콜백();
				}
			}
		};
	}
} );




// 명시적인 dataType이 제공되지 않은 경우 스크립트의 자동 실행을 방지합니다(gh-2432 참조).
jQuery.ajaxPrefilter( 함수( s ) {
	if (s.crossDomain) {
		s.contents.script = false;
	}
} );

// 스크립트 dataType 설치
jQuery.ajaxSetup({
	수락: {
		스크립트: "텍스트/자바스크립트, 애플리케이션/자바스크립트, " +
			"응용 프로그램/ecmascript, 응용 프로그램/x-ecmascript"
	},
	내용물: {
		스크립트: /\b(?:java|ecma)script\b/
	},
	변환기: {
		"텍스트 스크립트": 함수( 텍스트 ) {
			jQuery.globalEval(텍스트);
			텍스트 반환;
		}
	}
} );

// 캐시의 특별한 경우와 crossDomain을 처리합니다.
jQuery.ajaxPrefilter( "스크립트", 함수( s ) {
	if ( s.cache === 정의되지 않음 ) {
		s.cache = 거짓;
	}
	if (s.crossDomain) {
		s.type = "GET";
	}
} );

// 스크립트 태그 해킹 전송 바인딩
jQuery.ajaxTransport( "스크립트", 함수( s ) {

	// 이 전송은 도메인 간 요청이나 속성에 의한 강제 요청만 처리합니다.
	if ( s.crossDomain || s.scriptAttrs ) {
		var 스크립트, 콜백;
		반품 {
			보내기: 함수( _, 완료) {
				스크립트 = jQuery( "<스크립트>" )
					.attr( s.scriptAttrs || {} )
					.prop( { charset: s.scriptCharset, src: s.url } )
					.on( "로드 오류", 콜백 = function( evt ) {
						script.remove();
						콜백 = null;
						if (evt) {
							완료( evt.type === "error" ? 404 : 200, evt.type );
						}
					} );

				// domManip AJAX 속임수를 피하기 위해 기본 DOM 조작을 사용합니다.
				document.head.appendChild( script[ 0 ] );
			},
			중단: 함수() {
				if(콜백) {
					콜백();
				}
			}
		};
	}
} );




var oldCallbacks = [],
	rjsonp = /(=)\?(?=&|$)|\?\?/;

// 기본 jsonp 설정
jQuery.ajaxSetup({
	jsonp: "콜백",
	jsonpCallback: 함수() {
		var 콜백 = oldCallbacks.pop() || ( jQuery.expando + "_" + ( nonce.guid++ ) );
		this[ 콜백 ] = true;
		콜백 반환;
	}
} );

// jsonp 요청에 대한 옵션을 감지, 정규화하고 콜백을 설치합니다.
jQuery.ajaxPrefilter( "json jsonp", function( s, originalSettings, jqXHR ) {

	var callbackName, 덮어쓰기, responseContainer,
		jsonProp = s.jsonp !== false && ( rjsonp.test( s.url ) ?
			"URL":
			s.data 유형 === "문자열" &&
				( s.contentType || "" )
					.indexOf( "application/x-www-form-urlencoded" ) === 0 &&
				rjsonp.test( s.data ) && "데이터"
		);

	// 예상되는 데이터 유형이 "jsonp"이거나 설정할 매개변수가 있는 경우 처리합니다.
	if ( jsonProp || s.dataTypes[ 0 ] === "jsonp" ) {

		// 콜백 이름을 가져오고 이와 관련된 기존 값을 기억합니다.
		callbackName = s.jsonpCallback = isFunction( s.jsonpCallback ) ?
			s.jsonpCallback() :
			s.jsonp콜백;

		// URL이나 양식 데이터에 콜백을 삽입합니다.
		if (jsonProp) {
			s[ jsonProp ] = s[ jsonProp ].replace( rjsonp, "$1" + callbackName );
		} else if ( s.jsonp !== false ) {
			s.url += ( rquery.test( s.url ) ? "&" : "?" ) + s.jsonp + "=" + callbackName;
		}

		// 데이터 변환기를 사용하여 스크립트 실행 후 json을 검색합니다.
		s.converters[ "script json" ] = function() {
			if (!responseContainer) {
				jQuery.error( callbackName + " 호출되지 않았습니다." );
			}
			return responseContainer[ 0 ];
		};

		// json 데이터 유형을 강제로 적용합니다.
		s.dataTypes[ 0 ] = "json";

		// 콜백 설치
		덮어쓰기 = 창[ callbackName ];
		창[ 콜백이름 ] = 함수() {
			responseContainer = 인수;
		};

		// 정리 함수(변환기 이후에 실행됨)
		jqXHR.always(함수() {

			// 이전 값이 존재하지 않으면 제거합니다.
			if ( 덮어쓰기 === 정의되지 않음 ) {
				jQuery(창).removeProp(콜백이름);

			// 그렇지 않으면 기존 값을 복원합니다.
			} 또 다른 {
				창[ callbackName ] = 덮어쓰기;
			}

			// 무료로 다시 저장
			if ( s[ 콜백이름 ] ) {

				// 옵션을 재사용해도 문제가 발생하지 않는지 확인하세요.
				s.jsonpCallback = originalSettings.jsonpCallback;

				// 나중에 사용할 수 있도록 콜백 이름을 저장합니다.
				oldCallbacks.push( callbackName );
			}

			// 함수이고 응답이 있으면 호출합니다.
			if ( responseContainer && isFunction( 덮어쓰기 ) ) {
				덮어쓰기( responseContainer[ 0 ] );
			}

			responseContainer = 덮어쓰기 = 정의되지 않음;
		} );

		// 스크립트에 위임
		"스크립트"를 반환합니다.
	}
} );




// 지원: Safari 8만 해당
// document.implementation.createHTMLDocument를 통해 생성된 Safari 8 문서에서
// 형제 형식 축소: 두 번째 형식이 첫 번째 형식의 자식이 됩니다.
// 따라서 이 보안 조치는 Safari 8에서 비활성화되어야 합니다.
// https://bugs.webkit.org/show_bug.cgi?id=137337
support.createHTMLDocument = ( function() {
	var body = document.implementation.createHTMLDocument( "" ).body;
	body.innerHTML = "<form></form><form></form>";
	return body.childNodes.length === 2;
} )();


// 인수 "data"는 html의 문자열이어야 합니다.
// context (선택 사항): 지정하면 이 컨텍스트에서 조각이 생성됩니다.
// 기본값은 문서입니다.
// keepScripts (선택 사항): true인 경우 html 문자열에 전달된 스크립트를 포함합니다.
jQuery.parseHTML = 함수( 데이터, 컨텍스트, keepScripts ) {
	if ( 데이터 유형 !== "string" ) {
		반품 [];
	}
	if (컨텍스트 유형 === "부울") {
		keepScripts = 컨텍스트;
		컨텍스트 = 거짓;
	}

	var 기본, 구문 분석, 스크립트;

	만약 (!컨텍스트) {

		// 스크립트나 인라인 이벤트 핸들러가 즉시 실행되는 것을 중지합니다.
		// document.implementation을 사용하여
		if(support.createHTMLDocument) {
			context = document.implementation.createHTMLDocument( "" );

			// 생성된 문서의 기본 href를 설정합니다.
			// 따라서 URL이 포함된 모든 구문 분석된 요소
			// 문서의 URL(gh-2965)을 기반으로 합니다.
			base = context.createElement( "base" );
			base.href = document.location.href;
			context.head.appendChild(베이스);
		} 또 다른 {
			컨텍스트 = 문서;
		}
	}

	구문 분석 = rsingleTag.exec(데이터);
	스크립트 = !keepScripts && [];

	// 단일 태그
	if (파싱됨) {
		return [ context.createElement( 구문 분석됨[ 1 ] ) ];
	}

	parsed = buildFragment( [ 데이터 ], 컨텍스트, 스크립트 );

	if ( 스크립트 && scripts.length ) {
		jQuery(스크립트).remove();
	}

	return jQuery.merge( [], parsed.childNodes );
};


/**
 * 페이지에 URL 로드
 */
jQuery.fn.load = function(url, params, callback) {
	var 선택기, 유형, 응답,
		본인=이것
		off = url.indexOf( " " );

	if (끄기 > -1) {
		선택기 = StripAndCollapse( url.slice( 끄기 ) );
		url = url.slice( 0, off );
	}

	// 함수라면
	if ( isFunction( params ) ) {

		// 콜백이라고 가정합니다.
		콜백 = 매개변수;
		매개변수 = 정의되지 않음;

	// 그렇지 않으면 매개변수 문자열을 만듭니다.
	} else if ( params && typeof params === "객체" ) {
		유형 = "포스트";
	}

	// 수정할 요소가 있으면 요청합니다.
	if ( self.length > 0 ) {
		jQuery.ajax({
			URL: URL,

			// "type" 변수가 정의되지 않은 경우 "GET" 메소드가 사용됩니다.
			// 이후 이 필드의 값을 명시적으로 만듭니다.
			// 사용자는 ajaxSetup 메소드를 통해 이를 재정의할 수 있습니다.
			유형: 유형 || "얻다",
			데이터 유형: "html",
			데이터: 매개변수
		} ).done( 함수( responseText ) {

			// 전체 콜백에 사용할 응답을 저장합니다.
			응답 = 인수;

			self.html( 선택자 ?

				// 선택기가 지정된 경우 더미 div에서 올바른 요소를 찾습니다.
				// IE '권한 거부' 오류를 방지하기 위해 스크립트를 제외합니다.
				jQuery( "<div>" ).append( jQuery.parseHTML( responseText ) ).find( 선택기 ) :

				// 그렇지 않으면 전체 결과를 사용합니다.
				응답텍스트 );

		// 요청이 성공하면 이 함수는 "data", "status", "jqXHR"을 가져옵니다.
		// 하지만 위에서 응답을 설정했기 때문에 무시됩니다.
		// 실패하면 이 함수는 "jqXHR", "status", "error"를 얻습니다.
		} ).always( 콜백 && 함수( jqXHR, 상태 ) {
			self.each(함수() {
				callback.apply( this, response || [ jqXHR.responseText, status, jqXHR ] );
			} );
		} );
	}

	이거 돌려줘;
};




jQuery.expr.pseudos.animated = function( elem ) {
	return jQuery.grep( jQuery.timers, 함수( fn ) {
		return elem === fn.elem;
	} ).길이;
};




jQuery.offset = {
	setOffset: 함수( elem, 옵션, i ) {
		var curPosition, curLeft, curCSSTop, curTop, curOffset, curCSSLeft, 계산 위치,
			위치 = jQuery.css( elem, "position" ),
			curElem = jQuery( 요소 ),
			소품 = {};

		// 위치를 먼저 설정합니다. 정적 요소에서도 위쪽/왼쪽이 설정된 경우
		if ( 위치 === "정적" ) {
			elem.style.position = "상대적";
		}

		curOffset = curElem.offset();
		curCSSTop = jQuery.css( elem, "top" );
		curCSSLeft = jQuery.css( elem, "left" );
		계산 위치 = ( 위치 === "절대" || 위치 === "고정" ) &&
			( curCSSTop + curCSSLeft ).indexOf( "auto" ) > -1;

		// 다음 중 하나인 경우 위치를 계산할 수 있어야 합니다.
		// 위쪽 또는 왼쪽은 자동이고 위치는 절대 또는 고정입니다.
		if (calculatePosition) {
			curPosition = curElem.position();
			curTop = curPosition.top;
			curLeft = curPosition.left;

		} 또 다른 {
			curTop = parsFloat( curCSSTop ) || 0;
			curLeft = parsFloat( curCSSLeft ) || 0;
		}

		if ( isFunction( 옵션 ) ) {

			// 여기에서 jQuery.extend를 사용하여 좌표 인수 수정을 허용합니다(gh-1848)
			options = options.call( elem, i, jQuery.extend( {}, curOffset ) );
		}

		if ( options.top != null ) {
			props.top = ( options.top - curOffset.top ) + curTop;
		}
		if ( options.left != null ) {
			props.left = ( options.left - curOffset.left ) + curLeft;
		}

		if (옵션에서 "사용") {
			options.using.call( elem, props );

		} 또 다른 {
			curElem.css(props);
		}
	}
};

jQuery.fn.extend({

	// offset()은 요소의 테두리 상자를 문서 원점과 연결합니다.
	오프셋: 함수(옵션) {

		// setter의 체이닝을 유지합니다.
		if (인수.길이) {
			반환 옵션 === 정의되지 않음?
				이것 :
				this.each( 함수( i ) {
					jQuery.offset.setOffset( this, options, i );
				} );
		}

		변수 직사각형, 승리,
			elem = this[ 0 ];

		if ( !elem ) {
			반품;
		}

		// 연결이 끊어지고 숨겨진(표시: 없음) 요소에 대해 0을 반환합니다(gh-2310)
		// 지원: IE <=11만 해당
		// getBoundingClientRect 실행
		// IE에서 연결이 끊어진 노드에서 오류가 발생합니다.
		if ( !elem.getClientRects().length ) {
			return { 위쪽: 0, 왼쪽: 0 };
		}

		// 뷰포트 기준 gBCR에 뷰포트 스크롤을 추가하여 문서 기준 위치를 가져옵니다.
		ret = elem.getBoundingClientRect();
		승리 = elem.ownerDocument.defaultView;
		반품 {
			상단: ret.top + win.pageYOffset,
			왼쪽: ret.left + win.pageXOffset
		};
	},

	// position()은 요소의 여백 상자를 오프셋 부모의 패딩 상자와 연결합니다.
	// 이는 CSS 절대 위치 지정 동작에 해당합니다.
	위치: 함수() {
		if ( !this[ 0 ] ) {
			반품;
		}

		var offsetParent, 오프셋, 문서,
			요소 = 이[ 0 ],
			parentOffset = { 위쪽: 0, 왼쪽: 0 };

		// 위치:고정 요소는 뷰포트로부터 오프셋되며 뷰포트 자체는 항상 오프셋이 0입니다.
		if ( jQuery.css( elem, "position" ) === "fixed" ) {

			// position:fixed는 getBoundingClientRect의 가용성을 의미한다고 가정합니다.
			오프셋 = elem.getBoundingClientRect();

		} 또 다른 {
			오프셋 = this.offset();

			// 문서 또는 루트 요소일 수 있는 *실제* 오프셋 상위를 고려합니다.
			// 정적으로 위치된 요소가 식별될 때
			doc = elem.ownerDocument;
			offsetParent = elem.offsetParent || doc.documentElement;
			while( offsetParent &&
				( offsetParent === doc.body || offsetParent === doc.documentElement ) &&
				jQuery.css( offsetParent, "position" ) === "static" ) {

				offsetParent = offsetParent.parentNode;
			}
			if ( offsetParent && offsetParent !== elem && offsetParent.nodeType === 1 ) {

				// 테두리가 콘텐츠 원점 외부에 있으므로 오프셋에 테두리를 통합합니다.
				parentOffset = jQuery( offsetParent ).offset();
				parentOffset.top += jQuery.css( offsetParent, "borderTopWidth", true );
				parentOffset.left += jQuery.css( offsetParent, "borderLeftWidth", true );
			}
		}

		// 상위 오프셋과 요소 여백을 뺍니다.
		반품 {
			상단: offset.top - parentOffset.top - jQuery.css( elem, "marginTop", true ),
			왼쪽: offset.left - parentOffset.left - jQuery.css( elem, "marginLeft", true )
		};
	},

	// 이 메소드는 다음과 같은 경우 documentElement를 반환합니다.
	// 1) offsetParent가 없는 iframe 내부 요소의 경우 이 메서드는 다음을 반환합니다.
	// 부모 창의 documentElement
	// 2) 숨겨진 요소나 분리된 요소의 경우
	// 3) 본문 또는 html 요소의 경우, 즉 html 노드의 경우 - 자체적으로 반환됩니다.
	//
	// 그러나 이러한 예외는 실제 사용 사례로 제시된 적이 없습니다.
	// 더 바람직한 결과로 간주될 수 있습니다.
	//
	// 그러나 이 논리는 보장되지 않으며 향후 언제든지 변경될 수 있습니다.
	offsetParent: 함수() {
		return this.map( function() {
			var offsetParent = this.offsetParent;

			while ( offsetParent && jQuery.css( offsetParent, "position" ) === "static" ) {
				offsetParent = offsetParent.offsetParent;
			}

			offsetParent를 반환 || 문서요소;
		} );
	}
} );

// scrollLeft 및 scrollTop 메소드 생성
jQuery.each( { scrollLeft: "pageXOffset", scrollTop: "pageYOffset" }, function( method, prop ) {
	var top = "pageYOffset" === 소품;

	jQuery.fn[ 메서드 ] = 함수( val ) {
		반환 액세스( this, function( elem, method, val ) {

			// 문서와 창을 병합합니다.
			var 승리;
			if ( isWindow( elem ) ) {
				승리 = 요소;
			} else if ( elem.nodeType === 9 ) {
				승리 = elem.defaultView;
			}

			if (val === 정의되지 않음) {
				승리를 반환 ? 승리[소품] : 요소[방법];
			}

			만약 (승리) {
				win.scrollTo(
					!맨 위 ? 값 : win.pageXOffset,
					맨 위 ? 값 : win.pageYOffset
				);

			} 또 다른 {
				elem[ 메소드 ] = val;
			}
		}, 메소드, 값, 인수.길이 );
	};
} );

// 지원: 사파리 <=7 - 9.1, 크롬 <=37 - 49
// jQuery.fn.position을 사용하여 상단/왼쪽 cssHooks를 추가합니다.
// 웹킷 버그: https://bugs.webkit.org/show_bug.cgi?id=29084
// 깜박임 버그: https://bugs.chromium.org/p/chromium/issues/detail?id=589347
// getCompulatedStyle은 위쪽/왼쪽/아래/오른쪽에 대해 지정된 경우 백분율을 반환합니다.
// CSS 모듈을 오프셋 모듈에 종속시키는 대신 여기에서 확인하세요.
jQuery.each( [ "top", "left" ], function( _i, prop ) {
	jQuery.cssHooks[ prop ] = addGetHookIf( support.pixelPosition,
		함수(요소, 계산됨) {
			if (계산됨) {
				계산 = curCSS( elem, prop );

				// curCSS가 백분율을 반환하면 오프셋으로 대체됩니다.
				rnumnonpx.test(계산됨)을 반환합니까?
					jQuery( elem ).position()[ prop ] + "px" :
					계산;
			}
		}
	);
} );


// innerHeight, innerWidth, height, width, externalHeight 및 externalWidth 메소드 생성
jQuery.each( { 높이: "높이", 너비: "너비" }, 함수( 이름, 유형 ) {
	jQuery.each({
		패딩: "내부" + 이름,
		컨텐츠 타입,
		"": "외부" + 이름
	}, 함수( defaultExtra, funcName ) {

		// 여백은 externalHeight, externalWidth에만 적용됩니다.
		jQuery.fn[ funcName ] = 함수( 여백, 값 ) {
			var chainable =args.length && ( defaultExtra || 여백 유형 !== "boolean" ),
				extra = defaultExtra || ( 여백 === true || 값 === true ? "margin" : "border" );

			반환 액세스( this, function( elem, type, value ) {
				var 문서;

				if ( isWindow( elem ) ) {

					// $( window ).outerWidth/Height 반환(스크롤바 포함)(gh-1729)
					return funcName.indexOf( "outer" ) === 0 ?
						elem[ "내부" + 이름 ] :
						elem.document.documentElement[ "클라이언트" + 이름 ];
				}

				// 문서 너비 또는 높이를 가져옵니다.
				if ( elem.nodeType === 9 ) {
					doc = elem.documentElement;

					// 스크롤[너비/높이] 또는 오프셋[너비/높이] 또는 클라이언트[너비/높이],
					// 가장 큰 것
					Math.max(
						elem.body[ "스크롤" + 이름 ], doc[ "스크롤" + 이름 ],
						elem.body[ "오프셋" + 이름 ], doc[ "오프셋" + 이름 ],
						문서[ "클라이언트" + 이름 ]
					);
				}

				반환 값 === 정의되지 않음 ?

					// 요소의 너비 또는 높이를 가져옵니다. 요청은 하지만 강제로 요청하지는 않습니다.parseFloat
					jQuery.css( elem, type, extra ) :

					// 요소의 너비 또는 높이를 설정합니다.
					jQuery.style( elem, 유형, 값, 추가 );
			}, 유형, 연결 가능 ? 마진 : 정의되지 않음, 연결 가능 );
		};
	} );
} );


jQuery.each( [
	"아약스스타트",
	"아약스중지",
	"아약스완료",
	"아약스오류",
	"아약스성공",
	"아약스보내기"
], 함수( _i, 유형 ) {
	jQuery.fn[ 유형 ] = 함수( fn ) {
		return this.on( type, fn );
	};
} );




jQuery.fn.extend({

	바인드: 함수( 유형, 데이터, fn ) {
		return this.on(types, null, data, fn);
	},
	바인딩 해제: 함수( 유형, fn ) {
		return this.off( 유형, null, fn );
	},

	대리자: 함수( 선택기, 유형, 데이터, fn ) {
		return this.on( 유형, 선택기, 데이터, fn );
	},
	위임 취소: 함수( 선택기, 유형, fn ) {

		// ( 네임스페이스 ) 또는 ( 선택기, 유형 [, fn] )
		returnargs.length === 1 ?
			this.off( 선택기, "**" ) :
			this.off( 유형, 선택기 || "**", fn );
	},

	hover: 함수( fnOver, fnOut ) {
		return this.mouseenter( fnOver ).mouseleave( fnOut || fnOver );
	}
} );

jQuery.각(
	( "블러 포커스 포커스인 포커스아웃 크기 조정 스크롤 클릭 dblclick " +
	"mousedown mouseup mousemouse mouseover mouseout mouseenter mouseleave " +
	"변경 선택 제출 키다운 키누름 키업 컨텍스트 메뉴" ).split( " " ),
	함수( _i, 이름 ) {

		// 이벤트 바인딩 처리
		jQuery.fn[ 이름 ] = 함수( 데이터, fn ) {
			반환 인수.길이 > 0 ?
				this.on( 이름, null, 데이터, fn ) :
				this.trigger(이름);
		};
	}
);




// 지원: Android <=4.0 전용
// BOM과 NBSP를 잘랐는지 확인하세요.
var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;

// 함수를 컨텍스트에 바인딩하고 선택적으로 부분적으로 적용합니다.
// 인수.
// jQuery.proxy는 표준(특히 Function#bind)을 홍보하기 위해 더 이상 사용되지 않습니다.
// 단, 조만간 제거될 예정은 아닙니다.
jQuery.proxy = 함수(fn,컨텍스트){
	var tmp, 인수, 프록시;

	if (컨텍스트 유형 === "문자열") {
		tmp = fn[컨텍스트];
		컨텍스트 = fn;
		fn = tmp;
	}

	// 사양에서 대상이 호출 가능한지 빠르게 확인합니다.
	// TypeError가 발생하지만 정의되지 않은 결과를 반환합니다.
	if ( !isFunction( fn ) ) {
		정의되지 않은 반환;
	}

	// 시뮬레이션된 바인드
	args = Slice.call( 인수, 2 );
	프록시 = 함수() {
		return fn.apply( context || this, args.concat( Slice.call( 인수 ) ) );
	};

	// 고유 핸들러의 guid를 원래 핸들러와 동일하게 설정하여 제거할 수 있도록 합니다.
	Proxy.guid = fn.guid = fn.guid || jQuery.guid++;

	프록시 반환;
};

jQuery.holdReady = 함수( 보유 ) {
	만약 (보류) {
		jQuery.readyWait++;
	} 또 다른 {
		jQuery.ready( true );
	}
};
jQuery.isArray = Array.isArray;
jQuery.parseJSON = JSON.parse;
jQuery.nodeName = 노드이름;
jQuery.isFunction = isFunction;
jQuery.isWindow = isWindow;
jQuery.camelCase = camelCase;
jQuery.type = toType;

jQuery.now = Date.now;

jQuery.isNumeric = 함수( obj ) {

	// jQuery 3.0부터 isNumeric은 다음으로 제한됩니다.
	// 문자열과 숫자(원시형 또는 객체)
	// 유한수로 강제 변환 가능(gh-2662)
	var type = jQuery.type(obj);
	return ( 유형 === "숫자" || 유형 === "문자열" ) &&

		//parseFloat NaNs 숫자 캐스팅 거짓 긍정("")
		// ...하지만 선행 숫자 문자열, 특히 16진수 리터럴("0x...")을 잘못 해석합니다.
		// 뺄셈은 무한대가 NaN이 되도록 강제합니다.
		!isNaN( obj - parsFloat( obj ) );
};

jQuery.trim = 함수(텍스트) {
	반환 텍스트 == null ?
		"" :
		( 텍스트 + "" ).replace( rtrim, "" );
};



// jQuery는 다른 모듈과 연결될 수 있으므로 명명된 AMD 모듈로 등록합니다.
// 정의를 사용할 수 있지만 적절한 연결 스크립트를 통하지 않는 파일
// 익명의 AMD 모듈을 이해합니다. AMD라는 이름의 제품이 가장 안전하고 강력합니다.
// 등록 방법입니다. AMD 모듈 이름은 소문자 jquery가 사용됩니다.
// 파일 이름에서 파생되며 jQuery는 일반적으로 소문자로 전달됩니다.
// 파일 이름. AMD 모듈이 원하는 경우 전역을 생성한 후 이 작업을 수행하십시오.
// 이 버전의 jQuery를 숨기기 위해 noConstrict를 호출하면 작동합니다.

// 최대 이식성을 위해 jQuery가 아닌 라이브러리는
// 자신을 익명 모듈로 선언하고 전역 설정을 피합니다.
// AMD 로더가 존재합니다. jQuery는 특별한 경우입니다. 자세한 내용은 다음을 참조하세요.
// https://github.com/jrburke/requirejs/wiki/Updating-existing-libraries#wiki-anon

if ( typeof 정의 === "함수" && 정의.amd ) {
	정의("jquery", [], function() {
		jQuery를 반환;
	} );
}




var

	// 덮어쓸 경우 jQuery를 통해 매핑
	_jQuery = window.jQuery,

	// 덮어쓰는 경우 $ 위에 매핑
	_$ = 창.$;

jQuery.noConflect = 함수(깊은) {
	if (window.$ === jQuery) {
		창.$ = _$;
	}

	if ( deep && window.jQuery === jQuery ) {
		window.jQuery = _jQuery;
	}

	jQuery를 반환;
};

// AMD에서도 jQuery 및 $ 식별자를 노출합니다.
// (#7102#comment:10, https://github.com/jquery/jquery/pull/557)
// 및 브라우저 에뮬레이터용 CommonJS(#13566)
if ( typeof noGlobal === "정의되지 않음" ) {
	window.jQuery = window.$ = jQuery;
}




jQuery를 반환;
} );