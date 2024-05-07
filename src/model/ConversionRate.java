package model;

public class ConversionRate {

    private String currencyBase; // Código de la moneda a ser convertida. Ejemplo: USD
    private String currencyTarget; // Código de la moneda a la que se va a convertir. Ejemplo: EUR
    private double exchangeRate; // Tasa de cambio de la moneda a ser convertida. Ejemplo: 0.9342
    private double conversionBase; // Cantidad de la moneda a ser convertida. Ejemplo: 1 (USD)
    private double convertedAmount; // Resultado de la conversión. Ejemplo: 0.9342 (EUR)

    // Constructor
    public ConversionRate(String currencyBase, String currencyTarget, double exchangeRate) {
        this.currencyBase = currencyBase;
        this.currencyTarget = currencyTarget;
        this.exchangeRate = exchangeRate;
    }

    // Actualiza la cantidad de la moneda a ser convertida y recalcula el resultado de la conversión
    private void setConversionBase(double conversionBase){
        this.conversionBase = conversionBase;
    }

    // Devuelve la cantidad de la moneda a ser convertida
    public double getConvertedAmount() {
        return convertedAmount;
    }

    // Calcula el resultado de la conversión
    public void convertTo(double conversionBase) {
        setConversionBase(conversionBase);
        this.convertedAmount = Math.round(conversionBase * exchangeRate);
    }

    // Devuelve una cadena con la información de la conversión
    @Override
    public String toString() {
        return "ConversionRate{" +
                "currencyBase='" + currencyBase + '\'' +
                ", currencyTarget='" + currencyTarget + '\'' +
                ", exchangeRate=" + exchangeRate +
                ", conversionBase=" + conversionBase +
                ", convertedAmount=" + convertedAmount +
                '}';
    }

    // Devuelve una respuesta con la información de la conversión
    public String getResponse() {
        return "[!] La conversión de " + conversionBase + " " + currencyBase + " es " + convertedAmount + " " + currencyTarget + "\n";
    }
}
