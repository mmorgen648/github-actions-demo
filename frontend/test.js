// Einfache Tests für Demo
console.log('Running frontend tests...');

// Test 1: Grundlegende Funktionalität
function testBasic() {
  const expected = 'Hello, World!';
  const actual = 'Hello, World!';

  if (expected === actual) {
    console.log('✓ Test 1: Basic test passed');
    return true;
  } else {
    console.error('✗ Test 1: Basic test failed');
    return false;
  }
}

// Test 2: Greet Funktion
function testGreet() {
  const greet = (name) => `Hello, ${name}!`;
  const result = greet('GitHub Actions');

  if (result === 'Hello, GitHub Actions!') {
    console.log('✓ Test 2: Greet function passed');
    return true;
  } else {
    console.error('✗ Test 2: Greet function failed');
    return false;
  }
}

// Test 3: Array Operations
function testArray() {
  const numbers = [1, 2, 3, 4, 5];
  const sum = numbers.reduce((a, b) => a + b, 0);

  if (sum === 15) {
    console.log('✓ Test 3: Array test passed');
    return true;
  } else {
    console.error('✗ Test 3: Array test failed');
    return false;
  }
}

// Alle Tests ausführen
const results = [
  testBasic(),
  testGreet(),
  testArray()
];

// Ergebnis
const allPassed = results.every(r => r === true);

if (allPassed) {
  console.log('\n✓ All tests passed! 🎉');
  process.exit(0);
} else {
  console.error('\n✗ Some tests failed!');
  process.exit(1);
}
