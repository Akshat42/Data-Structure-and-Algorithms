interface RomanArabicPair {
  [key: string]: number;
}

const stdPair: RomanArabicPair = {
  M: 1000,
  CM: 900,
  D: 500,
  CD: 400,
  C: 100,
  XC: 90,
  L: 50,
  XL: 40,
  X: 10,
  IX: 9,
  V: 5,
  IV: 4,
  I: 1,
};

function convertToRoman(number: number) {
  if (!number || number <= 0) {
    console.log('number must be greater than zero');
    return;
  }
  let roman = '';
  while (number != 0) {
    for (let key in stdPair) {
      if (number >= stdPair[key]) {
        roman = roman.concat(key);
        number = number - stdPair[key];
        break;
      }
    }
  }
  return roman;
}

console.log(convertToRoman(4));
