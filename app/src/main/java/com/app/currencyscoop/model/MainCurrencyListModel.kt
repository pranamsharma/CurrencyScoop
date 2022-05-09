package com.app.currencyscoop.model


data class MainCurrencyListModel(
    val meta: BothClass.Meta,
    val response: BothClass.Response


)

class BothClass{
    data class Meta(
        val code: Int,
        val disclaimer: String
    )

    data class Response(
        val fiats: Fiats
    )
}



data class Fiats(
    val AED: AED,
    val AFN: AFN,
    val ALL: ALL,
    val AMD: AMD,
    val ANG: ANG,
    val AOA: AOA,
    val ARS: ARS,
    val AUD: AUD,
    val AWG: AWG,
    val AZN: AZN,
    val BAM: BAM,
    val BBD: BBD,
    val BDT: BDT,
    val BGN: BGN,
    val BHD: BHD,
    val BIF: BIF,
    val BMD: BMD,
    val BND: BND,
    val BOB: BOB,
    val BOV: BOV,
    val BRL: BRL,
    val BSD: BSD,
    val BTN: BTN,
    val BWP: BWP,
    val BYN: BYN,
    val BZD: BZD,
    val CAD: CAD,
    val CDF: CDF,
    val CHE: CHE,
    val CHF: CHF,
    val CHW: CHW,
    val CLF: CLF,
    val CLP: CLP,
    val CNY: CNY,
    val COP: COP,
    val COU: COU,
    val CRC: CRC,
    val CUC: CUC,
    val CUP: CUP,
    val CVE: CVE,
    val CZK: CZK,
    val DJF: DJF,
    val DKK: DKK,
    val DOP: DOP,
    val DZD: DZD,
    val EGP: EGP,
    val ERN: ERN,
    val ETB: ETB,
    val EUR: EUR,
    val FJD: FJD,
    val FKP: FKP,
    val GBP: GBP,
    val GEL: GEL,
    val GHS: GHS,
    val GIP: GIP,
    val GMD: GMD,
    val GNF: GNF,
    val GTQ: GTQ,
    val GYD: GYD,
    val HKD: HKD,
    val HNL: HNL,
    val HRK: HRK,
    val HTG: HTG,
    val HUF: HUF,
    val IDR: IDR,
    val ILS: ILS,
    val INR: INR,
    val IQD: IQD,
    val IRR: IRR,
    val ISK: ISK,
    val JMD: JMD,
    val JOD: JOD,
    val JPY: JPY,
    val KES: KES,
    val KGS: KGS,
    val KHR: KHR,
    val KMF: KMF,
    val KPW: KPW,
    val KRW: KRW,
    val KWD: KWD,
    val KYD: KYD,
    val KZT: KZT,
    val LAK: LAK,
    val LBP: LBP,
    val LKR: LKR,
    val LRD: LRD,
    val LSL: LSL,
    val LYD: LYD,
    val MAD: MAD,
    val MDL: MDL,
    val MGA: MGA,
    val MKD: MKD,
    val MMK: MMK,
    val MNT: MNT,
    val MOP: MOP,
    val MRU: MRU,
    val MUR: MUR,
    val MVR: MVR,
    val MWK: MWK,
    val MXN: MXN,
    val MXV: MXV,
    val MYR: MYR,
    val MZN: MZN,
    val NAD: NAD,
    val NGN: NGN,
    val NIO: NIO,
    val NOK: NOK,
    val NPR: NPR,
    val NZD: NZD,
    val OMR: OMR,
    val PAB: PAB,
    val PEN: PEN,
    val PGK: PGK,
    val PHP: PHP,
    val PKR: PKR,
    val PLN: PLN,
    val PYG: PYG,
    val QAR: QAR,
    val RON: RON,
    val RSD: RSD,
    val RUB: RUB,
    val RWF: RWF,
    val SAR: SAR,
    val SBD: SBD,
    val SCR: SCR,
    val SDG: SDG,
    val SEK: SEK,
    val SGD: SGD,
    val SHP: SHP,
    val SLL: SLL,
    val SOS: SOS,
    val SRD: SRD,
    val SSP: SSP,
    val STN: STN,
    val SVC: SVC,
    val SYP: SYP,
    val SZL: SZL,
    val THB: THB,
    val TJS: TJS,
    val TMT: TMT,
    val TND: TND,
    val TOP: TOP,
    val TRY: TRY,
    val TTD: TTD,
    val TWD: TWD,
    val TZS: TZS,
    val UAH: UAH,
    val UGX: UGX,
    val USD: USD,
    val USN: USN,
    val UYI: UYI,
    val UYU: UYU,
    val UYW: UYW,
    val UZS: UZS,
    val VES: VES,
    val VND: VND,
    val VUV: VUV,
    val WST: WST,
    val XAF: XAF,
    val XAG: XAG,
    val XAU: XAU,
    val XBA: XBA,
    val XBB: XBB,
    val XBC: XBC,
    val XBD: XBD,
    val XCD: XCD,
    val XDR: XDR,
    val XOF: XOF,
    val XPD: XPD,
    val XPF: XPF,
    val XPT: XPT,
    val XSU: XSU,
    val XTS: XTS,
    val XUA: XUA,
    val XXX: XXX,
    val YER: YER,
    val ZAR: ZAR,
    val ZMW: ZMW,
    val ZWL: ZWL
)

data class AED(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class AFN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ALL(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class AMD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ANG(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class AOA(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ARS(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class AUD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class AWG(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class AZN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BAM(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BBD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BDT(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BGN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BHD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BIF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BMD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BND(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BOB(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BOV(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BRL(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BSD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BTN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BWP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BYN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class BZD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CAD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CDF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CHE(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CHF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CHW(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CLF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CLP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CNY(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class COP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class COU(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CRC(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CUC(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CUP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CVE(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class CZK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class DJF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class DKK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class DOP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class DZD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class EGP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ERN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ETB(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class EUR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class FJD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class FKP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class GBP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class GEL(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class GHS(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class GIP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class GMD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class GNF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class GTQ(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class GYD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class HKD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class HNL(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class HRK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class HTG(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class HUF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class IDR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ILS(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class INR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class IQD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class IRR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ISK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class JMD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class JOD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class JPY(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class KES(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class KGS(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class KHR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class KMF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class KPW(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class KRW(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class KWD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class KYD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class KZT(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class LAK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class LBP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class LKR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class LRD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class LSL(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class LYD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MAD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MDL(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MGA(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MKD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MMK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MNT(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MOP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MRU(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MUR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MVR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MWK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MXN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MXV(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MYR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class MZN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class NAD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class NGN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class NIO(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class NOK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class NPR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class NZD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class OMR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class PAB(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class PEN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class PGK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class PHP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class PKR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class PLN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class PYG(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class QAR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class RON(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class RSD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class RUB(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class RWF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SAR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SBD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SCR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SDG(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SEK(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SGD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SHP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SLL(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SOS(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SRD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SSP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class STN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SVC(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SYP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class SZL(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class THB(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class TJS(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class TMT(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class TND(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class TOP(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class TRY(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class TTD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class TWD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class TZS(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class UAH(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class UGX(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class USD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class USN(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class UYI(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class UYU(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class UYW(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class UZS(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class VES(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class VND(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class VUV(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class WST(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XAF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XAG(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XAU(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XBA(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XBB(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XBC(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XBD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XCD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XDR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XOF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XPD(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XPF(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XPT(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XSU(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XTS(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XUA(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class XXX(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class YER(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ZAR(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ZMW(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)

data class ZWL(
    val countries: List<String>,
    val currency_code: String,
    val currency_name: String,
    val decimal_units: String
)