<?php
namespace concourse\thrift\shared;

/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
use Thrift\Base\TBase;
use Thrift\Type\TType;
use Thrift\Type\TMessageType;
use Thrift\Exception\TException;
use Thrift\Exception\TProtocolException;
use Thrift\Protocol\TProtocol;
use Thrift\Protocol\TBinaryProtocolAccelerated;
use Thrift\Exception\TApplicationException;


/**
 * Enumerates the list of operators that can be used in criteria specifications.
 */
final class Operator {
  const REGEX = 1;
  const NOT_REGEX = 2;
  const EQUALS = 3;
  const NOT_EQUALS = 4;
  const GREATER_THAN = 5;
  const GREATER_THAN_OR_EQUALS = 6;
  const LESS_THAN = 7;
  const LESS_THAN_OR_EQUALS = 8;
  const BETWEEN = 9;
  const LINKS_TO = 10;
  const LIKE = 11;
  const NOT_LIKE = 12;
  static public $__names = array(
    1 => 'REGEX',
    2 => 'NOT_REGEX',
    3 => 'EQUALS',
    4 => 'NOT_EQUALS',
    5 => 'GREATER_THAN',
    6 => 'GREATER_THAN_OR_EQUALS',
    7 => 'LESS_THAN',
    8 => 'LESS_THAN_OR_EQUALS',
    9 => 'BETWEEN',
    10 => 'LINKS_TO',
    11 => 'LIKE',
    12 => 'NOT_LIKE',
  );
}

/**
 * Enumerates the possible TObject types
 */
final class Type {
  const BOOLEAN = 1;
  const DOUBLE = 2;
  const FLOAT = 3;
  const INTEGER = 4;
  const LONG = 5;
  const LINK = 6;
  const STRING = 7;
  const TAG = 8;
  const NULL = 9;
  static public $__names = array(
    1 => 'BOOLEAN',
    2 => 'DOUBLE',
    3 => 'FLOAT',
    4 => 'INTEGER',
    5 => 'LONG',
    6 => 'LINK',
    7 => 'STRING',
    8 => 'TAG',
    9 => 'NULL',
  );
}

final class Diff {
  const ADDED = 1;
  const REMOVED = 2;
  static public $__names = array(
    1 => 'ADDED',
    2 => 'REMOVED',
  );
}

/**
 * A temporary token that is returned by the
 * {@link ConcourseService#login(String, String)} method to grant access
 * to secure resources in place of raw credentials.
 */
class AccessToken {
  static $_TSPEC;

  /**
   * @var string
   */
  public $data = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'data',
          'type' => TType::STRING,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['data'])) {
        $this->data = $vals['data'];
      }
    }
  }

  public function getName() {
    return 'AccessToken';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRING) {
            $xfer += $input->readString($this->data);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('AccessToken');
    if ($this->data !== null) {
      $xfer += $output->writeFieldBegin('data', TType::STRING, 1);
      $xfer += $output->writeString($this->data);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

/**
 * A token that identifies a Transaction.
 */
class TransactionToken {
  static $_TSPEC;

  /**
   * @var \concourse\thrift\shared\AccessToken
   */
  public $accessToken = null;
  /**
   * @var int
   */
  public $timestamp = null;

  public function __construct($vals=null) {
    if (!isset(self::$_TSPEC)) {
      self::$_TSPEC = array(
        1 => array(
          'var' => 'accessToken',
          'type' => TType::STRUCT,
          'class' => '\concourse\thrift\shared\AccessToken',
          ),
        2 => array(
          'var' => 'timestamp',
          'type' => TType::I64,
          ),
        );
    }
    if (is_array($vals)) {
      if (isset($vals['accessToken'])) {
        $this->accessToken = $vals['accessToken'];
      }
      if (isset($vals['timestamp'])) {
        $this->timestamp = $vals['timestamp'];
      }
    }
  }

  public function getName() {
    return 'TransactionToken';
  }

  public function read($input)
  {
    $xfer = 0;
    $fname = null;
    $ftype = 0;
    $fid = 0;
    $xfer += $input->readStructBegin($fname);
    while (true)
    {
      $xfer += $input->readFieldBegin($fname, $ftype, $fid);
      if ($ftype == TType::STOP) {
        break;
      }
      switch ($fid)
      {
        case 1:
          if ($ftype == TType::STRUCT) {
            $this->accessToken = new \concourse\thrift\shared\AccessToken();
            $xfer += $this->accessToken->read($input);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        case 2:
          if ($ftype == TType::I64) {
            $xfer += $input->readI64($this->timestamp);
          } else {
            $xfer += $input->skip($ftype);
          }
          break;
        default:
          $xfer += $input->skip($ftype);
          break;
      }
      $xfer += $input->readFieldEnd();
    }
    $xfer += $input->readStructEnd();
    return $xfer;
  }

  public function write($output) {
    $xfer = 0;
    $xfer += $output->writeStructBegin('TransactionToken');
    if ($this->accessToken !== null) {
      if (!is_object($this->accessToken)) {
        throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
      }
      $xfer += $output->writeFieldBegin('accessToken', TType::STRUCT, 1);
      $xfer += $this->accessToken->write($output);
      $xfer += $output->writeFieldEnd();
    }
    if ($this->timestamp !== null) {
      $xfer += $output->writeFieldBegin('timestamp', TType::I64, 2);
      $xfer += $output->writeI64($this->timestamp);
      $xfer += $output->writeFieldEnd();
    }
    $xfer += $output->writeFieldStop();
    $xfer += $output->writeStructEnd();
    return $xfer;
  }

}

