package s99

import org.scalatest.funspec.AnyFunSpec
import s99.S99Logic._

class S99LogicSpec extends AnyFunSpec {

  describe("Logical operators using S99Logic implicit conversion") {

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
        assert(true.and(true) == true)
        assert(true.and(false) == false)
        assert(false.and(true) == false)
        assert(false.and(false) == false)
      }
    }

    describe("or") {
      it("should return true if at least one input is true") {
        assert(true.or(true) == true)
        assert(true.or(false) == true)
        assert(false.or(true) == true)
        assert(false.or(false) == false)
      }
    }

    describe("nand") {
      it("should return false only when both inputs are true") {
        assert(true.nand(true) == false)
        assert(true.nand(false) == true)
        assert(false.nand(true) == true)
        assert(false.nand(false) == true)
      }
    }

    describe("nor") {
      it("should return true only when both inputs are false") {
        assert(true.nor(true) == false)
        assert(true.nor(false) == false)
        assert(false.nor(true) == false)
        assert(false.nor(false) == true)
      }
    }

    describe("xor") {
      it("should return true only when inputs differ") {
        assert(true.xor(true) == false)
        assert(true.xor(false) == true)
        assert(false.xor(true) == true)
        assert(false.xor(false) == false)
      }
    }

    describe("impl (implication)") {
      it("should be false only when a is true and b is false") {
        assert(true.impl(true) == true)
        assert(true.impl(false) == false)
        assert(false.impl(true) == true)
        assert(false.impl(false) == true)
      }
    }

    describe("equ (equivalence)") {
      it("should return true when both inputs are the same") {
        assert(true.equ(true) == true)
        assert(false.equ(false) == true)
        assert(true.equ(false) == false)
        assert(false.equ(true) == false)
      }
    }
  }
}
