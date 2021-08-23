// 6: arrow functions - binding
// To do: make all tests pass, leave the asserts unchanged!

class LexicallyBound {
  
  getFunction() {
    return () => {
      return this;
    }
  }
  
  // here we use a classic function to it as the 'arguments' param
  // see https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Fonctions/arguments
  getArgumentsFunction() {
    return function() {return arguments}
  }
  
  // here we us an arrow function so it does not have iti's own 'arguments'
  // https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Fonctions/Fonctions_fl%C3%A9ch%C3%A9es
  // Remark : Here I use the shortest way to define an arrow function (no return if single line)
  getArgumentsArrowFunction() {
    return () =>  arguments
  }
  
}

describe('arrow functions have lexical `this`, no dynamic `this`', () => {
 
  it('bound at definition time, use `=>` ', function() {
    var bound = new LexicallyBound();
    var fn = bound.getFunction();
    
    assert.strictEqual(fn(), bound);
  });
 
  it('can NOT bind a different context', function() {
    var bound = new LexicallyBound();
    var fn = bound.getFunction();
    var anotherObj = fn();
    var expected = anotherObj;
    
    assert.strictEqual(fn.call(anotherObj), expected);
  });
  
  // https://developer.mozilla.org/fr/docs/Web/JavaScript/Reference/Fonctions/arguments
  
  it('`arguments` doesnt work inside arrow functions', function() {
    var bound = new LexicallyBound();
    var getArgFn = bound.getArgumentsArrowFunction();
    
    assert.equal(getArgFn(1, 2).length, 0);
  });
  
});
