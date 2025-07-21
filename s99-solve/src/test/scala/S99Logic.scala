package s99

import org.scalatest.funspec.AnyFunSpec

class S99LogicSpec extends AnyFunSpec {
  import s99.S99Logic._

  describe("Logical operators") {

    describe("not") {
      it("should negate true to false") {
        assert(not(true) == false)
      }
      it("should negate false to true") {
        assert(not(false) == true)
      }
    }

    describe("and") {
      it("should return true only when both inputs are true") {
        assert(and(true, true) == true)
        assert(and(true, false) == false)
        assert(and(false, true) == false)
        assert(and(false, false) == false)
      }
    }

    describe("or") {
      it("should return true if at least one input is true") {
        assert(or(true, true) == true)
        assert(or(true, false) == true)
        assert(or(false, true) == true)
        assert(or(false, false) == false)
      }
    }

    describe("nand") {
      it("should return false only when both inputs are true") {
        assert(nand(true, true) == false)
        assert(nand(true, false) == true)
        assert(nand(false, true) == true)
        assert(nand(false, false) == true)
      }
    }

    describe("nor") {
      it("should return true only when both inputs are false") {
        assert(nor(true, true) == false)
        assert(nor(true, false) == false)
        assert(nor(false, true) == false)
        assert(nor(false, false) == true)
      }
    }

    describe("xor") {
      it("should return true only when inputs differ") {
        assert(xor(true, true) == false)
        assert(xor(true, false) == true)
        assert(xor(false, true) == true)
        assert(xor(false, false) == false)
      }
    }

    describe("impl (implication)") {
      it("should be false only when a is true and b is false") {
        assert(impl(true, true) == true)
        assert(impl(true, false) == false)
        assert(impl(false, true) == true)
        assert(impl(false, false) == true)
      }
    }

    describe("equ (equivalence)") {
      it("should return true when both inputs are the same") {
        assert(equ(true, true) == true)
        assert(equ(false, false) == true)
        assert(equ(true, false) == false)
        assert(equ(false, true) == false)
      }
    }
  }
}
